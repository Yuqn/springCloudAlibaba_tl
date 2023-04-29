package com.yuqn.filters;

//import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

/**
 * @author: yuqn
 * @Date: 2023/4/29 19:15
 * @description:
 * 全局过滤器，比如可以全局记录日志
 * @version: 1.0
 */
@Component
public class LogFilter implements GlobalFilter {

//    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 这里写逻辑
        // og.info(exchange.getRequest().getPath().value());
        System.out.println("记录path"+exchange.getRequest().getPath().value());
        return chain.filter(exchange);
    }
}
