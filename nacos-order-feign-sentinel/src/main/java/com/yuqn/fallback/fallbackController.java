package com.yuqn.fallback;

import com.yuqn.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class fallbackController implements OrderService {

    @Override
    public String test() {
        return "服务降级";
    }

    @Override
    public String test2() {
        return "服务降级";
    }
}
