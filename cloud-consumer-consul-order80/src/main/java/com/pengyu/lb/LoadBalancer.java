package com.pengyu.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * <p>
 * 自己写的轮询算法接口
 * </p>
 *
 * @author weipengyu
 * @since 2021/4/13-20:26
 */
public interface LoadBalancer {
    // 收集服务器总共有多少台能够提供服务的机器，并放到list里面
    ServiceInstance instance(List<ServiceInstance> serviceInstanceList);
}
