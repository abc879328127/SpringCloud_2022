package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.advice.SysLog;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.loadbalancer.LoadBalancer;
import com.atguigu.springcloud.loadbalancer.MyLB;
import com.atguigu.springcloud.utils.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author: guojd
 * @date: 2022/9/2 下午11:02
 */
@Slf4j
@RestController
public class OrderEurekaController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
//    public static final String PAYMENT_URL = "http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;

    //自定义轮询
    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @SysLog
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public ReturnResult getPaymentById2(@PathVariable("id") Long id) {
        ResponseEntity<ReturnResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, ReturnResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else{
            return new ReturnResult<>(null);
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public ReturnResult getLoadBalancer(){
        //获取eureka服务器上的所有服务
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0 ){
            return ReturnResult.succeedReturn();
        }
        //通过自己写的方法实现负载均衡
        ServiceInstance instances1 = loadBalancer.instances(instances);
        URI uri = instances1.getUri();
        return ReturnResult.succeedReturn(restTemplate.getForObject(uri+"/payment/lb",String.class));
    }
}
