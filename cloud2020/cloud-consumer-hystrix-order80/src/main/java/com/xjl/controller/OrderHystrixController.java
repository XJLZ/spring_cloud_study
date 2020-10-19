package com.xjl.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xjl.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-08 13:32
 * @Modified By:
 */
@Slf4j
@RestController
@RequestMapping("/consumer/payment/hystrix")
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }


    @HystrixCommand(fallbackMethod = "paymentTimeOutFallBackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @GetMapping("/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
//        int result = 1 / 0;
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    public String paymentTimeOutFallBackMethod(@PathVariable("id") Integer id) {
        log.info("====我是消费者80，对方支付系统繁忙=====");
        return "我是消费者80，对方支付系统繁忙，请稍后再试，o(╥﹏╥)o";
    }

    @GetMapping("/global")
    @HystrixCommand
    public String global() {
        int result = 1 / 0;
        return paymentHystrixService.paymentInfo_TimeOut(1);
    }

    public String paymentGlobalFallbackMethod() {
        return "Payment_Global_FallbackMethod: 全局异常处理，系统繁忙，请稍后再试，o(╥﹏╥)o";
    }


}
