package com.yuqn.controller;

import com.yuqn.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("test")
    public String test(){
        String msg = orderService.test();
        return "订单" + msg;
    }
}
