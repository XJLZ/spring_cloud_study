package com.xjl.controller;

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
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/consul")
    public String paymentConsul() {
        return "springcloud with consul：" + serverPort + "\t" + UUID.randomUUID().toString();
    }

    @GetMapping("timeout")
    public String timeout(){
        // 暂停3秒
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
