package com.atguigu.springcloud.service;

import com.atguigu.springcloud.advice.SysLog;
import com.atguigu.springcloud.utils.ReturnResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @SysLog
    @GetMapping(value = "/payment/get/{id}")
    ReturnResult getPaymentById1(@PathVariable("id") Long id);

}
