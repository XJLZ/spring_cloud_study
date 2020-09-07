package com.xjl.controller;

import com.xjl.domain.Payment;
import com.xjl.service.PaymentService;
import com.xjl.vo.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Author: 玲
 * @Description:
 * @create 2020-08-10 17:39
 * @Modified By:
 */
@RequestMapping("/payment")
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discovery")
    public Object discovery(){
        // 获取所有服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("=============element:" + service);
        }
        // 获取一个具体微服务的所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"====="+instance.getPort()+"====="+instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/lb")
    public String loadBalance(){
        return port;
    }
}
