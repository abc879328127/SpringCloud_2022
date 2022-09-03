package com.atguigu.springcloud.utils;

import java.io.Serializable;

/**
 * @author: guojd
 * @date: 2022/9/1 下午9:28
 */
public class ReturnResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private Integer amount;
    private String serverPort;
    private String msg;
    private Long cost;
    private T data;
    public ReturnResult() {
    }
    public ReturnResult(Integer amount, String serverPort) {
        this.amount = amount;
        this.serverPort = serverPort;
    }
    public ReturnResult(Integer code, String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public ReturnResult(CustomExceptionEnum customExceptionEnum,Integer amount, String serverPort) {
        this.amount = amount;
        this.serverPort = serverPort;
        this.code = customExceptionEnum.getResultCode();
        this.msg = customExceptionEnum.getResultMsg();
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

    public ReturnResult(CustomExceptionEnum customExceptionEnum,T data, String serverPort) {
        this.code = customExceptionEnum.getResultCode();
        this.data = data;
        this.msg = customExceptionEnum.getResultMsg();
        this.serverPort = serverPort;
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
    public static ReturnResult succeedReturn(Integer amount,String serverPort) {
        return new ReturnResult(CustomExceptionEnum.SUCCESS,amount,serverPort);
    }
    public static ReturnResult succeedReturnTakePort(CustomExceptionEnum customExceptionEnum,Integer amount,String serverPort) {
        return new ReturnResult(customExceptionEnum,amount,serverPort);
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
    public static <T> ReturnResult succeedReturn(T data,String serverPort) {
        return new ReturnResult(CustomExceptionEnum.SUCCESS, data,serverPort);
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

    public String getServerPort() {
        return serverPort;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
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
        return "ReturnResult(code=" + this.getCode() + ", message=" + this.getMsg() + ", cost=" + this.getCost() +", serverPort=" + this.getServerPort()+", amount=" + this.getAmount()+ ", data=" + this.getData() + ")";
    }
}