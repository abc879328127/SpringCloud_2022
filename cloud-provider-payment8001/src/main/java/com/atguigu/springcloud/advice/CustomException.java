package com.atguigu.springcloud.advice;

/**
 *
 * 异常实体类
 *
 * @author: dzd
 * @date: 2022/4/12
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
