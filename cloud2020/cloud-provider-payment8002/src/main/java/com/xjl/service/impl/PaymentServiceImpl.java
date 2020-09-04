package com.xjl.service.impl;

import com.xjl.dao.PaymentMapper;
import com.xjl.domain.Payment;
import com.xjl.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-08-10 17:37
 * @Modified By:
 */
@Service("payment")
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper mapper;

    @Override
    public int create(Payment payment) {
        return mapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return mapper.getPaymentById(id);
    }
}
