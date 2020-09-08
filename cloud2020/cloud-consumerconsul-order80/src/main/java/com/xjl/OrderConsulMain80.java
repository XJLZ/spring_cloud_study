package com.xjl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-07 11:10
 * @Modified By:
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class,args);
    }
}