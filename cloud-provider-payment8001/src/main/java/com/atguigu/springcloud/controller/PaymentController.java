package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.advice.SysLog;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.utils.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;

    @SysLog
    @PostMapping(value = "/payment/create")
    public ReturnResult create(@RequestBody Payment payment){
         return ReturnResult.succeedReturn(paymentService.create(payment),serverPort);

    }

    @SysLog
    @GetMapping(value = "/payment/get/{id}")
    public ReturnResult getPaymentById(@PathVariable("id") Long id){
        return ReturnResult.succeedReturn(paymentService.getPaymentById(id),serverPort);

    }

    @GetMapping(value = "/payment/discovery")
    public ReturnResult discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****element:"+ service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return ReturnResult.succeedReturn(this.discoveryClient);
    }

    @GetMapping(value = "/payment/lb")
    public String getLoadBalancer(){
        return serverPort;
    }
}
