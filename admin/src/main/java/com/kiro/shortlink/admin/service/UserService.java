package com.kiro.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kiro.shortlink.admin.dao.entity.UserDO;
import com.kiro.shortlink.admin.dto.req.UserLoginReqDTO;
import com.kiro.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.kiro.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.kiro.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.kiro.shortlink.admin.dto.resp.UserRespDTO;
import org.springframework.stereotype.Service;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240215 21:49
 * @desc 用户接口层
 */
@Service
public interface UserService extends IService<UserDO> {

    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return 用户返回信息实体
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * 判断用户名是否存在
     * @param username 用户名
     * @return 是否存在，返回true为存在
     */
    Boolean hasUsername(String username);

    /**
     * 用户注册
     * @param userRegisterReqDTO 用户注册请求参数
     */
    void register(UserRegisterReqDTO userRegisterReqDTO);

    /**
     * 根据用户名进行用户信息修改
     * @param userUpdateReqDTO 用户信息修改请求参数
     */
    void update(UserUpdateReqDTO userUpdateReqDTO);

    /**
     * 用户登录
     * @param userLoginReqDTO 用户登录请求参数
     * @return 用户登录返回参数
     */
    UserLoginRespDTO login(UserLoginReqDTO userLoginReqDTO);

    /**
     * 检查用户是否登录
     * @param username
     * @param token
     * @return 是否登录
     */
    Boolean checkLogin(String username, String token);

    /**
     * 用户登出
     * @param username
     * @param token
     */
    void logout(String username, String token);
}
