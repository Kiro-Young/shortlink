package com.kiro.shortlink.admin.dto.resp;

import lombok.Data;

import java.util.Date;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240215 22:59
 * @desc 用户返回参数响应DTO
 */
@Data
public class UserRespDTO {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;


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
