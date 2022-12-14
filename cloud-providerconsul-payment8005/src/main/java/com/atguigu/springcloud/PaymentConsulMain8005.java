package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient //该注解用于想consul或者zookeeper作为注册中心时注册服务
@SpringBootApplication
public class PaymentConsulMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8005.class, args);
    }
}
