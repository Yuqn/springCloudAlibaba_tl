package com.yuqn.predicates;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {


    public CheckAuthRoutePredicateFactory() {
        super(CheckAuthRoutePredicateFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        // ==================
        // 这里的值是创建属性的值
        // ==================
        return Arrays.asList("name");
    }

    @Override
    public Predicate<ServerWebExchange> apply(CheckAuthRoutePredicateFactory.Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange exchange) {
                // ====================
                // 这里添加条件，来确定返回
                // ====================
                System.out.println("==================================="+config.getName().toString());
                if(config.getName().equals("yuqn")){
                    System.out.println("匹配成功");
                    return true;
                }
                System.out.println("匹配失败");
                return false;
            }
        };
    }

    /**
     * @author: yuqn
     * @Date: 2023/4/29 2:38
     * @description:
     * 接收配置文件中断言属性值
     * @param: null
     * @return: null
     */
    @Validated
    public static class Config {

        // ==================
        // 创建属性接收自定义断言
        // ==================
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
