package com.xjl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-08 11:44
 * @Modified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigCenterMain3344  {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344 .class, args);
    }


}
