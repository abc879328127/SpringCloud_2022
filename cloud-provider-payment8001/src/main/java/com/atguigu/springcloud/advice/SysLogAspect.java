package com.atguigu.springcloud.advice;

import com.atguigu.springcloud.advice.CustomException;
import com.atguigu.springcloud.advice.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author: dzd
 * @date: 2022/4/12
 */
@Slf4j
@Aspect
@Order(-1)
@Configuration
public class SysLogAspect {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(com.atguigu.springcloud.advice.SysLog)")
    public void sysLog() {

    }

    @Around(value = "sysLog()")
    public ReturnResult aroundMethodExecution(ProceedingJoinPoint point)  {
        try {
            long startTimeStamp = System.currentTimeMillis();

            String methodName = point.getSignature().getName();
            Object[] args = point.getArgs();

            log.info("方法:{}, 入参:{}", methodName, args);
            Object proceed = point.proceed();
            long endTimeStamp = System.currentTimeMillis();
            long executionTime = endTimeStamp - startTimeStamp;
            log.info("方法:{} 执行时间为 {} ms", methodName, executionTime);

            if (proceed == null) return null;

            ReturnResult returnResult = (ReturnResult) proceed;
            returnResult.setCost(executionTime);
            return returnResult;
        } catch (Throwable throwable) {
            if (throwable instanceof CustomException) {
                return (ReturnResult.failReturn(((CustomException) throwable).getErrorCode(), ((CustomException) throwable).getErrorMsg()));
            } else {
                throwable.printStackTrace();
                ReturnResult rtnResult = new ReturnResult();
                rtnResult.setMsg("系统异常！");
                // 服务器遇到了一个未曾预料的状况，导致了它无法完成对请求的处理。一般来说，这个问题都会在服务器端的源代码出现错误时出现
                rtnResult.setCode(500);
                //异常入库
                return rtnResult;
            }
        }
    }


}
