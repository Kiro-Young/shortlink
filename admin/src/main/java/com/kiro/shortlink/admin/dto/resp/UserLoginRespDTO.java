package com.kiro.shortlink.admin.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240403 8:42
 */
/**
 * 用户登录接口返回响应
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRespDTO {

    /**
     * 用户Token
     */
    private String token;

}
