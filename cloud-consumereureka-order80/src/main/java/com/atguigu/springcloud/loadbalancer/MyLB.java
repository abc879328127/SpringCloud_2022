package com.atguigu.springcloud.loadbalancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer {

    //原子类
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){

        int current;
        int next;
        do{
            //获取原子当前值
            current = this.atomicInteger.get();
            //下一个值next 如果大于2147483647 就让其归零，不然current 就 +1
            next = current >= 2147483647 ? 0 : current + 1;
            //cas 知识，期望值是current，修改值next，如果没有，就一直自旋
            //如果拿到的是0，期望值还是0，期望值就是和拿到的值相同，才可以修改，就修改成修改值next
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("****第几次访问次数next"+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        //取余数，
        return serviceInstanceList.get(getAndIncrement() % serviceInstanceList.size());
    }
}
