package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.advice.SysLog;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.utils.ReturnResult;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping(value = "/payment/create")
    public ReturnResult create(Payment payment){

         return ReturnResult.succeedReturn(paymentService.create(payment));

    }

    @GetMapping(value = "/payment/get/{id}")
    public ReturnResult create(@PathVariable("id") Long id){

        return ReturnResult.succeedReturn(paymentService.getPaymentById(id));

    }

}
