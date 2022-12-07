package com.yuqn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuqn
 * @Description:
 * 通过注解的方式，使用 sentinel 流控规则
 * @date: 2022/10/27 17:59
 */
@RestController
@Slf4j
public class Test2Controller {
    /**
     * @author: yuqn
     * @Description:
     * 定义常量，对应请求的 RequestMapping 属性，方便使用，也可以不用定义
     * @date: 2022/10/27 16:29
     */
    private static final String RESOURCE_NAME = "test1";

    /**
     * @author: yuqn
     * @Description:
     * 通过 SentinelResource 注解的方法，进行 sentinel 操作
     * @SentinelResource 参数：
     *  value：指定请求名
     *  blockHandler：设置流控降级后的处理方法（默认该方法声明在同一个类中）
     *  blockHandlerClass：设置流控降级后的处理方法在哪个类中，如果不在同一个类中，方法需要使用 static 修饰
     *  fallback：异常处理方法
     *  fallbackClass：异常处理方法所在类
     *  exceptionsToIgnore：排除某些异常的处理
     * @date: 2022/10/27 18:00
     * @param: msg
     * @Return: String
     */
    @RequestMapping("/test1")
    @SentinelResource(value = RESOURCE_NAME,
            blockHandler = "fallbackHandle1")
    public String test1(String msg){
        return msg;
    }

    /**
     * @author: yuqn
     * @Description:
     * 定义方法，用于 sentinel 流控操作，
     *  注：返回值必须跟调用它的方法的返回值一致 String
     *      参数也要一致，并且可以添加异常类
     * @date: 2022/10/27 18:04
     */
    public String fallbackHandle1(String msg, BlockException ex){
        ex.printStackTrace();
        return "被流控了";
    }

    /**
     * @author: yuqn
     * @Description:
     * 设置限流规则，使用 @PostConstruct 注解，在创建 bean 的时候，会初始化这个方法
     * @date: 2022/10/27 16:39
     */
    @PostConstruct
    private static void initFlowRules1(){
        // 设置规则，FlowRule 流控规则
        List<FlowRule> rules1 = new ArrayList<>();
        // 流控
        FlowRule rule1 = new FlowRule();
        // 指定资源进行流控
        rule1.setResource(RESOURCE_NAME);
        // 设置流控规则
        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置受保护的资源阈值，超过则限制
        rule1.setCount(1);
        // 添加到 rules 中
        rules1.add(rule1);
        FlowRuleManager.loadRules(rules1);
    }

    /**
     * @Author: yuqn
     * @Date: 2022/10/27 19:34
     * @Description:
     *
     * @Version: 1.0
     */
    public List<String> test(String name){
        List list = new ArrayList();
        return list;
    }
}
