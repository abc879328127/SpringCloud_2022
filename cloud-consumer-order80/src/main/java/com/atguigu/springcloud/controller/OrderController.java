package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.advice.SysLog;
import com.atguigu.springcloud.utils.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: guojd
 * @date: 2022/9/2 下午11:02
*/
@Slf4j
@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;
    @SysLog
    @GetMapping("/payment/get/{id}")
    public ReturnResult test(@PathVariable("id") Long id){
        return restTemplate.getForObject("http://localhost:8001/payment/get/"+id, ReturnResult.class);
    }
}
