package com.xjl.controller;

import com.xjl.domain.Payment;
import com.xjl.service.PayMentService;
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
    private PayMentService payMentService;

    @PostMapping("save")
    public ResultResponse add(@RequestBody Payment payment){
        payMentService.save(payment);
        return ResultResponse.ok(payment);
    }

    @GetMapping("find")
    public ResultResponse getById(Long id){
        return ResultResponse.ok(payMentService.getById(id));
    }

}
