package com.xjl.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: 玲
 * @Description: 模拟 ILoadBalancer 的接口，选择哪一个负载算法和机器
 * @create 2020-09-07 15:26
 * @Modified By:
 */
public interface LoadBalancer {
    /**
     * 获取eureka上的活着的机器总数
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
