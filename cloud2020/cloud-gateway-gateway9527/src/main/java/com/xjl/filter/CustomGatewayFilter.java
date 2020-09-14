package com.xjl.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: 玲
 * @Description: 自定义过滤器，URI可指定
 * @create 2020-09-11 17:27
 * @Modified By:
 */
public class CustomGatewayFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("id");
        if (token == null) {
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        /**
         * 通过这个过滤器，进入过滤链中的下一个过滤器
         */
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
