package com.pengyu.lb;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 自己实现Ribbon轮询算法实现
 * </p>
 *
 * @author weipengyu
 * @since 2021/4/13-20:27
 */
@Slf4j
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取下标
     * @author weipengyu
     * @date 2021/4/13-20:29
     */
    private final int getAndIncrement(){
        int current = 0;
        int next = 0;
        do {
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
            //第一个参数是期望值，第二个参数是修改值
        }while (!atomicInteger.compareAndSet(current, next));
        log.info("这是第{}次访问", next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstanceList) {
        return null;
    }







/*
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //坐标
    private final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
            //第一个参数是期望值，第二个参数是修改值是
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*******第几次访问，次数next: "+next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() % serviceInstanceList.size();
        //得到服务器的下标位置
        return serviceInstanceList.get(index);
    }*/
}
