package com.xjl.dao;

import com.xjl.domain.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-08-10 17:33
 * @Modified By:
 */
@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
