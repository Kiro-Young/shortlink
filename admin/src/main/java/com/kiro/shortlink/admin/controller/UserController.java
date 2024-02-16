package com.kiro.shortlink.admin.controller;

import com.kiro.shortlink.admin.convention.result.Result;
import com.kiro.shortlink.admin.dto.resp.UserRespDTO;
import com.kiro.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240215 17:41
 * @discription 用户管理控制层
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    public Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username) {
        UserRespDTO result = userService.getUserByUsername(username);
        if (result == null) {
            return new Result<UserRespDTO>().setCode("-1").setMessage("用户不存在");
        } else {
            return new Result<UserRespDTO>().setCode("0").setData(result).setMessage("查询成功");
        }
    }
}
