package com.xjl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-10 17:05
 * @Modified By:
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9002.class,args);
    }
}