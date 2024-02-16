package com.kiro.shortlink.admin.common.convention.errorcode;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240216 12:18
 * @desc 平台错误码接口
 */

public interface IErrorCode {

    /**
     * 错误码
     * @return 错误码
     */
    String code();

    /**
     * 错误信息
     * @return 错误信息
     */
    String message();
}
