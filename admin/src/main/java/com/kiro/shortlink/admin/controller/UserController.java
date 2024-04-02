package com.kiro.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.kiro.shortlink.admin.common.convention.result.Result;
import com.kiro.shortlink.admin.common.convention.result.Results;
import com.kiro.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.kiro.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.kiro.shortlink.admin.dto.resp.UserActualRespDTO;
import com.kiro.shortlink.admin.dto.resp.UserRespDTO;
import com.kiro.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/api/short-link/v1/user/{username}")
    public Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUsername(username));
    }

    @GetMapping("/api/short-link/v1/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUsername(@PathVariable("username") String username) {
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualRespDTO.class));
    }

    @GetMapping("/api/short-link/v1/user/has/{username}")
    public Result<Boolean> hasUsername(@PathVariable("username") String username) {
        return Results.success(userService.hasUsername(username));
    }

    @PostMapping("/api/short-link/v1/user")
    public Result<Void> register(@RequestBody UserRegisterReqDTO userRegisterReqDTO) {
        userService.register(userRegisterReqDTO);
        return Results.success();
    }

    @PutMapping("/api/short-link/v1/user")
    public Result<Void> update(@RequestBody UserUpdateReqDTO userUpdateReqDTO) {
        userService.update(userUpdateReqDTO);
        return Results.success();
    }
}
