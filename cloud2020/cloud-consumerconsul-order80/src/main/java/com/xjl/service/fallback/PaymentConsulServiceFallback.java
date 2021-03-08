package com.xjl.service.fallback;

import com.xjl.service.PaymentConsulService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-12-18 15:14
 * @Modified By:
 */
@Slf4j
@Component
public class PaymentConsulServiceFallback implements FallbackFactory<PaymentConsulService> {
    @Override
    public PaymentConsulService create(Throwable throwable) {
        return new PaymentConsulService() {
            @Override
            public String paymentConsul() {
                log.error("调用consul-provider-payment-paymentConsul出错",throwable);
                return "调用consul-provider-payment-paymentConsul出错";
            }

            @Override
            public String timeout() {
                log.error("调用consul-provider-payment-timeout出错",throwable);
                return "调用consul-provider-payment-paymentConsul出错";
            }
        };
    }
}
