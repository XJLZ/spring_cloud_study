package com.xjl.controller;

import com.xjl.domain.Payment;
import com.xjl.vo.ResultResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-08-10 20:02
 * @Modified By:
 */
@RestController
@RequestMapping("customer")
public class OrderController {

    private static final String PAYMENT_URL="http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/save")
    public ResultResponse create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/save",payment, ResultResponse.class);
    }

    @GetMapping("/payment/get/{id}")
    public ResultResponse getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/find?id="+id,ResultResponse.class);
    }
}
