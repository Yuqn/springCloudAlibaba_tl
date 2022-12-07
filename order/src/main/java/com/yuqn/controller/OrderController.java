package com.yuqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("test")
    public String test(){
        String msg = restTemplate.getForObject("http://localhost:8081/test1",String.class);
        return "订单" + msg;
    }
}
