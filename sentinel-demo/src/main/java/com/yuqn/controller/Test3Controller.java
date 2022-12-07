package com.yuqn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test3Controller {

    @RequestMapping("/test3")
    public String test3(){
        return "测试第三个";
    }
}
