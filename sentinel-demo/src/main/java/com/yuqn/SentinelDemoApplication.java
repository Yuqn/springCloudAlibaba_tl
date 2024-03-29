package com.yuqn;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SentinelDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelDemoApplication.class, args);
    }

    // 注解支持的配置bean
    @Bean
    public SentinelResourceAspect sentinelResourceAspect(){
        return new SentinelResourceAspect();
    }
}
