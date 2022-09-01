package com.atguigu.springcloud.advice;

import java.io.Serializable;

/**
 * @author: dzd
 * @date: 2022/4/12
 */
public class ReturnResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;
    private Long cost;
    private T data;
    public ReturnResult() {
    }
    public ReturnResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public ReturnResult(Integer code, String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ReturnResult(CustomExceptionEnum customExceptionEnum) {
        this.code = customExceptionEnum.getResultCode();
        this.msg = customExceptionEnum.getResultMsg();
    }

    public ReturnResult(CustomExceptionEnum customExceptionEnum, Long cost) {
        this.code = customExceptionEnum.getResultCode();
        this.cost = cost;
        this.msg = customExceptionEnum.getResultMsg();
    }

    public ReturnResult(CustomExceptionEnum customExceptionEnum, T data) {
        this.code = customExceptionEnum.getResultCode();
        this.data = data;
        this.msg = customExceptionEnum.getResultMsg();
    }

    public ReturnResult(CustomExceptionEnum customExceptionEnum, Long cost, T data) {
        this.code = customExceptionEnum.getResultCode();
        this.msg = customExceptionEnum.getResultMsg();
        this.cost = cost;
        this.data = data;
    }

    public static ReturnResult succeedReturn(String executionTime) {
        return new ReturnResult(CustomExceptionEnum.SUCCESS, executionTime);
    }
    public static ReturnResult succeedReturn(Integer code,String msg) {
        return new ReturnResult(code,msg);
    }
    public static<T> ReturnResult succeedReturn(Integer code, String msg, T data) {
        return new ReturnResult(code,msg,data);
    }

    public static ReturnResult succeedReturn(CustomExceptionEnum customExceptionEnum, Long cost) {
        return new ReturnResult(customExceptionEnum, cost);
    }

    public static <T> ReturnResult succeedReturn(CustomExceptionEnum customExceptionEnum, Long cost, T data) {
        return new ReturnResult(customExceptionEnum, cost, data);
    }

    public static <T> ReturnResult succeedReturn(CustomExceptionEnum customExceptionEnum, T data) {
        return new ReturnResult(customExceptionEnum, data);
    }

    public static <T> ReturnResult succeedReturn(T data) {
        return new ReturnResult(CustomExceptionEnum.SUCCESS, data);
    }

    public static ReturnResult succeedReturn(CustomExceptionEnum customExceptionEnum) {
        return new ReturnResult(customExceptionEnum);
    }

    public static ReturnResult succeedReturn() {
        return new ReturnResult(CustomExceptionEnum.SUCCESS);
    }

    public static ReturnResult failReturn(Integer code, String message) {
        return new ReturnResult(code, message);
    }

    public static ReturnResult failReturn(CustomExceptionEnum customExceptionEnum) {
        return new ReturnResult(customExceptionEnum);
    }

    public static ReturnResult failReturn(CustomExceptionEnum customExceptionEnum, String executionTime) {
        return new ReturnResult(customExceptionEnum, executionTime);
    }

    public static <T> ReturnResult failReturn(CustomExceptionEnum customExceptionEnum, T data) {
        return new ReturnResult(customExceptionEnum, data);
    }

    public static <T> ReturnResult failReturn(CustomExceptionEnum customExceptionEnum, Long cost, T data) {
        return new ReturnResult(customExceptionEnum, cost, data);
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public Long getCost() {
        return this.cost;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ReturnResult)) {
            return false;
        } else {
            ReturnResult<?> other = (ReturnResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label59;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label59;
                    }

                    return false;
                }

                Object this$cost = this.getCost();
                Object other$cost = other.getCost();
                if (this$cost == null) {
                    if (other$cost != null) {
                        return false;
                    }
                } else if (!this$cost.equals(other$cost)) {
                    return false;
                }

                Object this$message = this.getMsg();
                Object other$message = other.getMsg();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ReturnResult;
    }

//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        Object $code = this.getCode();
//        int result = result * 59 + ($code == null ? 43 : $code.hashCode());
//        Object $cost = this.getCost();
//        result = result * 59 + ($cost == null ? 43 : $cost.hashCode());
//        Object $message = this.getMessage();
//        result = result * 59 + ($message == null ? 43 : $message.hashCode());
//        Object $data = this.getData();
//        result = result * 59 + ($data == null ? 43 : $data.hashCode());
//        return result;
//    }

    public String toString() {
        return "ReturnResult(code=" + this.getCode() + ", message=" + this.getMsg() + ", cost=" + this.getCost() + ", data=" + this.getData() + ")";
    }
}