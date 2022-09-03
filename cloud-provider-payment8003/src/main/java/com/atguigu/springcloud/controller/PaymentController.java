package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.advice.SysLog;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.utils.CustomExceptionEnum;
import com.atguigu.springcloud.utils.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* @author: guojd
* @date: 2022/8/31 下午11:44
*/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @SysLog
    @PostMapping(value = "/payment/create")
    public ReturnResult create(@RequestBody Payment payment){

        return ReturnResult.succeedReturn(paymentService.create(payment),serverPort);

    }

    @SysLog
    @GetMapping(value = "/payment/get/{id}")
    public ReturnResult create(@PathVariable("id") Long id){
        return ReturnResult.succeedReturn(paymentService.getPaymentById(id),serverPort);

    }

}
