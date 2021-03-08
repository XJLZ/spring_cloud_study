package com.xjl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-07 10:23
 * @Modified By:
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/consul")
    public String paymentConsul() {
        log.info("consul-provider-payment"+ serverPort);
        int err = 1/0;
        return "springcloud with consul：" + serverPort + "\t" + UUID.randomUUID().toString();
    }

    @GetMapping("/timeout")
    public String timeout(){
        log.info("consul-provider-payment-timeout"+ serverPort);
        // 暂停3秒
        try {
            TimeUnit.SECONDS.sleep(6L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
