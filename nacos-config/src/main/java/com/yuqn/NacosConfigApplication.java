package com.yuqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NacosConfigApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigApplication.class,args);
        // 读取 nacos 配置
        String yuqnName = applicationContext.getEnvironment().getProperty("yuqn.name");
        String yuqnAge = applicationContext.getEnvironment().getProperty("yuqn.age");
        System.out.println("getName:" + yuqnName + "，getAge:" + yuqnAge);
    }
}
