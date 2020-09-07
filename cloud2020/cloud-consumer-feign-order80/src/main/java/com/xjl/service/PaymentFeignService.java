package com.xjl.service;

import com.xjl.vo.ResultResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-07 16:24
 * @Modified By:
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE")  //指定调用哪个微服务
public interface PaymentFeignService {


    @GetMapping("/payment/get/{id}")
    ResultResponse getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/lb")
    String getPort();

}
