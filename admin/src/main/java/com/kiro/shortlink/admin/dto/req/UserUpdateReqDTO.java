package com.kiro.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240402 21:23
 * @desc 用户请求修改信息参数
 */
@Data
public class UserUpdateReqDTO {

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
