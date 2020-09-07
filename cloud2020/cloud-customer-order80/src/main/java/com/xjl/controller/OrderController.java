package com.xjl.controller;

import com.xjl.domain.Payment;
import com.xjl.lb.LoadBalancer;
import com.xjl.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-08-10 20:02
 * @Modified By:
 */
@RestController
@RequestMapping("customer")
public class OrderController {

    //        private static final String PAYMENT_URL="http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVICE";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/save")
    public ResultResponse create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, ResultResponse.class);
    }

    @GetMapping("/payment/get/{id}")
    public ResultResponse getPayment(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, ResultResponse.class);
    }

    /**
     * 路由规则：轮询
     *
     * @param
     * @return
     */
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
