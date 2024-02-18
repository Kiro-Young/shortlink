package com.kiro.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240218 16:23
 * @desc 用户请求注册参数
 */
@Data
public class UserRegisterReqDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;
}
