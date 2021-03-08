package com.xjl.service;

import com.xjl.service.fallback.PaymentConsulServiceFallback;
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
@FeignClient(value = "consul-provider-payment",contextId = "consulClient",fallbackFactory = PaymentConsulServiceFallback.class)
public interface PaymentConsulService {

    @GetMapping("/payment/consul")
    String paymentConsul();

    @GetMapping("/payment/timeout")
    String timeout();
}
