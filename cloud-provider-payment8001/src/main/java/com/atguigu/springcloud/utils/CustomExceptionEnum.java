package com.atguigu.springcloud.utils;

/**
* @author: guojd
* @date: 2022/9/1 下午9:28
*/
public enum CustomExceptionEnum {

    SUCCESS(0, "success"),
    PARAM_BLANK_EXCEPTION(51001, "参数不能为空!"),
    PARAM_CHECK_EXCEPTION(51002, "%s"),
    IO_EXCEPTION(51003, "接口IO异常!"),
    UNKNOWN_EXCEPTION(51004, "服务内部错误!");

    private final Integer resultCode;
    private final String resultMsg;

    private CustomExceptionEnum(Integer resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public Integer getResultCode() {
        return this.resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }
}