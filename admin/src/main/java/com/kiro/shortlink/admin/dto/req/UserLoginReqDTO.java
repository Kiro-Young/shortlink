package com.kiro.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240403 8:46
 */
@Data
public class UserLoginReqDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
