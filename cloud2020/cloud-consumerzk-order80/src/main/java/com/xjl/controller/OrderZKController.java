package com.xjl.controller;

import com.xjl.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-04 17:40
 * @Modified By:
 */
@RequestMapping
@RestController
public class OrderZKController {
//    public static final String INVOKE_URL = "http://cloud-provider-payment";

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/zk")
    public String loadBalance(){
        return paymentFeignService.getPort();
    }

//    @GetMapping("/payment/zk")
//    public String paymentInfo(){
//        String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
//        return result;
//    }
}
