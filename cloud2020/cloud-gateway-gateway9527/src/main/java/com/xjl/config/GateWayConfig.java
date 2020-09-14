package com.xjl.config;

import com.xjl.filter.CustomGatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-10 20:20
 * @Modified By:
 */
//@Configuration
public class GateWayConfig {
    /**
     * 配置一个id为route-name的路由规则，
     * 当访问地址http://localhost:9527/guonei时会自动转发到地址：http://news.baidu.com/guonei
     *
     * @param routeLocatorBuilder
     * @return
     */
//    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_baidu",
                r -> r.path("/payment/hystrix/ok/**")
                        .uri("lb://cloud-provider-hystrix-payment")
                        .filters(new CustomGatewayFilter()))
                .build();
        return routes.build();
    }
}
