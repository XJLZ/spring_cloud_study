package com.xjl.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-08 13:34
 * @Modified By:
 */
@Component
@FeignClient(value = "cloud-provider-hystrix-payment", fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {


    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);



}
