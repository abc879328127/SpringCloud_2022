package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.advice.SysLog;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.utils.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author: guojd
 * @date: 2022/9/2 下午11:02
 */
@Slf4j
@RestController
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
//    public static final String PAYMENT_URL = "http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;

    @SysLog
    @PostMapping("/consumer/payment/create")
    public ReturnResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create/", payment, ReturnResult.class);
    }

    @SysLog
    @GetMapping("/consumer/payment/get/{id}")
    public ReturnResult getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/" + id, ReturnResult.class);
    }
}
