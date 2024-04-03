package com.kiro.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.kiro.shortlink.admin.common.convention.result.Result;
import com.kiro.shortlink.admin.common.convention.result.Results;
import com.kiro.shortlink.admin.dto.req.UserLoginReqDTO;
import com.kiro.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.kiro.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.kiro.shortlink.admin.dto.resp.UserActualRespDTO;
import com.kiro.shortlink.admin.dto.resp.UserLoginRespDTO;
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

    /**
     * 根据用户名获取用户真实信息
     * @param username 用户名
     * @return 用户信息
     */
    @GetMapping("/api/short-link/v1/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUsername(@PathVariable("username") String username) {
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualRespDTO.class));
    }

    /**
     * 判断用户名是否存在
     * @param username 用户名
     * @return 是否存在，返回true为存在
     */
    @GetMapping("/api/short-link/v1/user/has/{username}")
    public Result<Boolean> hasUsername(@PathVariable("username") String username) {
        return Results.success(userService.hasUsername(username));
    }

    /**
     * 用户注册
     * @param userRegisterReqDTO 用户注册请求参数
     * @return 用户注册返回参数
     */
    @PostMapping("/api/short-link/v1/user")
    public Result<Void> register(@RequestBody UserRegisterReqDTO userRegisterReqDTO) {
        userService.register(userRegisterReqDTO);
        return Results.success();
    }

    /**
     * 根据用户名进行用户信息修改
     * @param userUpdateReqDTO 用户信息修改请求参数
     * @return 用户信息修改返回参数
     */
    @PutMapping("/api/short-link/v1/user")
    public Result<Void> update(@RequestBody UserUpdateReqDTO userUpdateReqDTO) {
        userService.update(userUpdateReqDTO);
        return Results.success();
    }

    /**
     * 用户登录
     * @param userLoginReqDTO 用户登录请求参数
     * @return 用户登录返回参数
     */
    @PostMapping("/api/short-link/v1/user/login")
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO userLoginReqDTO) {
        return Results.success(userService.login(userLoginReqDTO));
    }

    /**
     * 检查用户是否登录
     * @param username 用户名
     * @param token token
     * @return 是否登录
     */
    @GetMapping("/api/short-link/v1/user/check-login")
    public Result<Boolean> checkLogin(@RequestParam("username") String username, @RequestParam("token") String token) {
        return Results.success(userService.checkLogin(username, token));
    }

    @DeleteMapping("/api/short-link/v1/user/logout")
    public Result<Void> logout(@RequestParam("username") String username, @RequestParam("token") String token) {
        userService.logout(username, token);
        return Results.success();
    }
}
