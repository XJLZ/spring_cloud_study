package com.xjl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-07 16:23
 * @Modified By:
 */
@SpringBootApplication
@EnableFeignClients //开启Feign
public class OrderFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}