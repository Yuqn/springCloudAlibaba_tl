package com.yuqn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StockController {

    @RequestMapping("test1")
    public String test(){
        return "stock";
    }

    @RequestMapping("test2")
    public String test2(){
        int a = 1/0;
        return "方法二";
    }
}
