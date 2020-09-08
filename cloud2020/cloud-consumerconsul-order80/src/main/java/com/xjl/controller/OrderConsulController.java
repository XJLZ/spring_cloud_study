package com.xjl.controller;

import com.xjl.service.PaymentConsulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-07 11:09
 * @Modified By:
 */
@RestController
@RequestMapping("/consumer")
public class OrderConsulController {

    public static final String INVOKE_URL = "http://consul-provider-peyment";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PaymentConsulService paymentConsulService;


    @GetMapping("/consul/of")
    public String openFeign() {
        return paymentConsulService.paymentConsul();
    }

    @GetMapping("/consul/timeout")
    public String timeout() {
        return paymentConsulService.timeout();
    }

    @GetMapping("/consul")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }


}
