package com.xjl.controller;

import com.xjl.domain.Payment;
import com.xjl.service.PaymentService;
import com.xjl.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${server.port}")
    private String port;

    @PostMapping("save")
    public ResultResponse add(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0){
            return ResultResponse.ok(result);
        }else{
            return ResultResponse.error("插入失败");
        }
    }

    @GetMapping("get/{id}")
    public ResultResponse getById(@PathVariable Long id) {
        ResultResponse hs = new ResultResponse();
        hs.setMessage(port);
        hs.setData(paymentService.getPaymentById(id));
        return hs;
    }

    @GetMapping("/lb")
    public String loadBalance(){
        return port;
    }
}
