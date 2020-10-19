package com.xjl.service;

import org.springframework.stereotype.Component;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-08 14:06
 * @Modified By:
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "降级处理------paymentInfo_OK---请稍后再试，o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "降级处理------paymentInfo_TimeOut--请稍后再试，o(╥﹏╥)o";
    }

}
