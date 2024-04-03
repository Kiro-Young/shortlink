package com.kiro.shortlink.admin.common.constant;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240218 18:34
 * @desc Redis缓存常量
 */
public class RedisCacheConstant {

    /**
     * 用户注册分布式锁
     */
    public static final String LOCK_USER_REGISTER = "short-link:lock_user-register:";

    /**
     * 用户登录缓存标识
     */
    public static final String USER_LOGIN_KEY = "short-link:login:";
}
