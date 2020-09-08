package com.xjl.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-08 9:59
 * @Modified By:
 */
@Component
@FeignClient("consul-provider-payment")
public interface PaymentConsulService {

    @GetMapping("/payment/consul")
    String paymentConsul();
}
