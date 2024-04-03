package com.kiro.shortlink.admin.common.enums;

import com.kiro.shortlink.admin.common.convention.errorcode.IErrorCode;

public enum UserErrorCodeEnums implements IErrorCode {

    // ========== 二级宏观错误码 用户信息错误 ==========
    USER_NULL("B000200", "用户记录不存在"),

    USER_NAME_EXIST("B000201", "用户名已存在"),

    USER_EXIST("B000202", "用户记录存在"),

    USER_SAVE_ERROR("B000203", "用户记录保存失败"),

    USER_LOGIN_ERROR("B000204", "用户登录错误"),
    USER_LOGOUT_ERROR("B000205", "用户Token不存在或用户未登录");

    private final String code;

    private final String message;

    UserErrorCodeEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
