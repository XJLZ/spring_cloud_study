package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-07 15:00
 * @Modified By:
 */
@Configuration
public class MyRule {

    @Bean
    public IRule random(){
        return new RandomRule();
    }
}
