package com.xjl.service;


import com.xjl.domain.Payment;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-08-10 17:36
 * @Modified By:
 */
public interface PaymentService{

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
