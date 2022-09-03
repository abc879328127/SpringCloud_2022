package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: guojd
 * @date: 2022/8/31 下午11:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;


    public CommonResult(Integer code, String message) {
//        this(code, message, null); 等同于下方
        this.code = code;
        this.message = message;
        this.data = null;

    }
}
