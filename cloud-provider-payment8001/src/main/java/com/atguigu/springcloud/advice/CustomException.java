package com.atguigu.springcloud.advice;

import com.atguigu.springcloud.utils.CustomExceptionEnum;

/**
 * 异常实体类
 * @author: guojd
 * @date: 2022/9/1 下午11:44
*/
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer errorCode;
    private String errorMsg;

    public CustomException() {
    }

    public CustomException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CustomException(Integer errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CustomException(CustomExceptionEnum customExceptionEnum) {
        this.errorCode = customExceptionEnum.getResultCode();
        this.errorMsg = customExceptionEnum.getResultMsg();
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}
