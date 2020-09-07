package com.xjl.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-07 16:24
 * @Modified By:
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")  //指定调用哪个微服务
public interface PaymentFeignService {

    @GetMapping("/payment/zk")
    String getPort();

}
