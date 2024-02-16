package com.kiro.shortlink.admin.common.enums;

import com.kiro.shortlink.admin.common.convention.errorcode.IErrorCode;

public enum UserErrorCodeEnums implements IErrorCode {

    // ========== 二级宏观错误码 用户信息错误 ==========
    USER_NULL("B000200", "用户记录不存在"),

    USER_EXIST("B000201", "用户记录存在");

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
