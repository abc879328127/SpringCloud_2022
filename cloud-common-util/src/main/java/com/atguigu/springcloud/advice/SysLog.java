package com.atguigu.springcloud.advice;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
* 系统日志注解
* @author: guojd
* @date: 2022/9/1 下午11:41
*/
@Aspect
@Configuration
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SysLog {

	String value() default "方法";
}
