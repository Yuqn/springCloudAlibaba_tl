package com.yuqn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @RequestMapping("test1")
    public String test(){
        return "stock";
    }
}
