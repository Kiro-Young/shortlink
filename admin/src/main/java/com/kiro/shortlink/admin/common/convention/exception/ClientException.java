package com.kiro.shortlink.admin.common.convention.exception;

import com.kiro.shortlink.admin.common.convention.errorcode.BaseErrorCode;
import com.kiro.shortlink.admin.common.convention.errorcode.IErrorCode;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240216 12:43
 * @desc 客户端异常
 */
public class ClientException extends AbstractException {

    public ClientException(IErrorCode errorCode) {
        this(null, null, errorCode);
    }

    public ClientException(String message) {
        this(message, null, BaseErrorCode.CLIENT_ERROR);
    }

    public ClientException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ClientException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ClientException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}

