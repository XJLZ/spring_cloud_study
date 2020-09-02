package com.xjl.controller;

import com.xjl.domain.Payment;
import com.xjl.service.PaymentService;
import com.xjl.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: 玲
 * @Description:
 * @create 2020-08-10 17:39
 * @Modified By:
 */
@Validated
@RequestMapping("/payment")
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("save")
    public ResultResponse add(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0){
            return ResultResponse.ok(payment);
        }else{
            return ResultResponse.error("插入失败");
        }
    }

    @GetMapping("get/{id}")
    public ResultResponse getById(@PathVariable Long id) {
        return ResultResponse.ok(paymentService.getPaymentById(id));
    }

}
