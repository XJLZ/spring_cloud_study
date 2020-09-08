package com.xjl.controller;

import com.xjl.service.PaymentFeignService;
import com.xjl.vo.ResultResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-07 16:22
 * @Modified By:
 */
@RestController
@RequestMapping("/feign")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public ResultResponse getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/lb")
    public String loadBalance(){
        return paymentFeignService.getPort();
    }


}
