package com.kiro.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kiro.shortlink.admin.common.convention.exception.ClientException;
import com.kiro.shortlink.admin.common.enums.UserErrorCodeEnums;
import com.kiro.shortlink.admin.dao.entity.UserDO;
import com.kiro.shortlink.admin.dao.mapper.UserMapper;
import com.kiro.shortlink.admin.dto.req.UserLoginReqDTO;
import com.kiro.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.kiro.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.kiro.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.kiro.shortlink.admin.dto.resp.UserRespDTO;
import com.kiro.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.kiro.shortlink.admin.common.constant.RedisCacheConstant.USER_LOGIN_KEY;
import static com.kiro.shortlink.admin.common.enums.UserErrorCodeEnums.USER_NAME_EXIST;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240215 22:50
 * @desc 用户接口实现层
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO>
        implements UserService {

    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;

    private final RedissonClient redissonClient;

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public UserRespDTO getUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        if (userDO == null) {
            throw new ClientException(UserErrorCodeEnums.USER_NULL);
        }
        UserRespDTO result = new UserRespDTO();
        BeanUtils.copyProperties(userDO, result);
        return result;
    }

    @Override
    public Boolean hasUsername(String username) {
        return userRegisterCachePenetrationBloomFilter.contains(username);
    }

    @Override
    public void register(UserRegisterReqDTO userRegisterReqDTO) {
        if (hasUsername(userRegisterReqDTO.getUsername())) {
            throw new ClientException(USER_NAME_EXIST);
        }
        RLock lock = redissonClient.getLock("LOCK_USER_REGISTER" + userRegisterReqDTO.getUsername());
        try {
            if (lock.tryLock()) {
                int insert = baseMapper.insert(BeanUtil.toBean(userRegisterReqDTO, UserDO.class));
                if (insert < 1) {
                    throw new ClientException(UserErrorCodeEnums.USER_SAVE_ERROR);
                }
                userRegisterCachePenetrationBloomFilter.add(userRegisterReqDTO.getUsername());
                return;
            }
            throw new ClientException(USER_NAME_EXIST);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void update(UserUpdateReqDTO userUpdateReqDTO) {
        // TODO 验证当前用户名是否为登录用户
        LambdaUpdateWrapper<UserDO> updateWrapper = Wrappers.lambdaUpdate(UserDO.class)
                .eq(UserDO::getUsername, userUpdateReqDTO.getUsername());
        baseMapper.update(BeanUtil.toBean(userUpdateReqDTO, UserDO.class), updateWrapper);
    }

    @Override
    public UserLoginRespDTO login(UserLoginReqDTO userLoginReqDTO) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, userLoginReqDTO.getUsername())
                .eq(UserDO::getPassword, userLoginReqDTO.getPassword())
                .eq(UserDO::getDelFlag, 0);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        if (userDO == null) {
            throw new ClientException(UserErrorCodeEnums.USER_NULL);
        }
        Map<Object, Object> hasLoginMap = stringRedisTemplate.opsForHash().entries(USER_LOGIN_KEY + userDO.getUsername());
        if (CollUtil.isNotEmpty(hasLoginMap)) {
            stringRedisTemplate.expire(USER_LOGIN_KEY + userDO.getUsername(), 30L, TimeUnit.MINUTES);
            String token = hasLoginMap.keySet().stream()
                    .findFirst()
                    .map(Object::toString)
                    .orElseThrow(() -> new ClientException(UserErrorCodeEnums.USER_LOGIN_ERROR));
            return new UserLoginRespDTO(token);
        }

        /*
          Hash
          Key: login_用户名
          Value:
           Key: token标识
           Val: JSON 字符串（用户信息）
         */
        String uuid = UUID.randomUUID().toString();
        stringRedisTemplate.opsForHash().put(USER_LOGIN_KEY + userDO.getUsername(), uuid, JSON.toJSONString(userDO));
        stringRedisTemplate.expire(USER_LOGIN_KEY + userDO.getUsername(), 30L, TimeUnit.MINUTES);
        return new UserLoginRespDTO(uuid);
    }

    @Override
    public Boolean checkLogin(String username, String token) {
        return stringRedisTemplate.opsForHash().get(USER_LOGIN_KEY + username, token) != null;
    }
}

