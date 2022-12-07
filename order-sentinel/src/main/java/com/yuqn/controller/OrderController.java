package com.yuqn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @SentinelResource(value = "test")
    @RequestMapping("test")
    public String test(){
        return "订单";
    }

    @SentinelResource(value = "test1")
    @RequestMapping("test1")
    public String test1(){
        return "第二";
    }

    /**
     * @author: yuqn
     * @Date: 2022/11/1 0:18
     * @description:
     * 异常
     * @param: null
     * @return: null
     */
    @SentinelResource(value = "test1")
    @RequestMapping("err")
    public String err(){
        System.out.println(1/0);
        return "异常处理";
    }
    public String backforerr(){
        return "服务降级";
    }
}
