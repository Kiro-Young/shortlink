package com.kiro.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kiro.shortlink.admin.dao.entity.UserDO;
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
}
