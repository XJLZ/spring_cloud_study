package com.xjl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-04 17:38
 * @Modified By:
 */

@SpringBootApplication
@EnableFeignClients
public class OrderZKMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain80.class,args);
    }
}