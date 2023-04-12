package com.yuqn.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
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
 * 创建类测试 sentinel 限流
 * @date: 2022/10/27 16:25
 */
@RestController
@Slf4j
public class TestController {
    /**
     * @author: yuqn
     * @Description:
     * 定义常量，对应请求的 RequestMapping 属性，方便使用，也可以不用定义
     * @date: 2022/10/27 16:29
     */
    private static final String RESOURCE_NAME = "test";
    /**
     * @author: yuqn
     * @Description:
     * 测试 sentinel 限流
     * @date: 2022/10/27 16:26
     * @Return:
     */
    @RequestMapping("/test")
    public String test(){
        Entry entry = null;
        try {
            // sentinel 针对资源进行限制
            entry = SphU.entry(RESOURCE_NAME);
            // 打印日志返回
            String str = "hello world";
            log.info("==========" + str + "===========");
            return str;
        }catch (BlockException el){
            log.info("block!");
            return "被流控";
        }catch (Exception ex){
            // 限流处理，如果超过限制，则走下面代码
            Tracer.traceEntry(ex,entry);
        }finally {
            // 资源释放
            if(entry != null){
                entry.exit();
            }
        }
        return null;
    }

    /**
     * @author: yuqn
     * @Description:
     * 设置限流规则，使用 @PostConstruct 注解，在创建 bean 的时候，会初始化这个方法
     * @date: 2022/10/27 16:39
     */
//    @PostConstruct
//    private static void initFlowRules(){
//        // 设置规则，FlowRule 流控规则
//        List<FlowRule> rules = new ArrayList<>();
//        // 流控
//        FlowRule rule = new FlowRule();
//        // 指定资源进行流控
//        rule.setResource(RESOURCE_NAME);
//        // 设置流控规则
//        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        // 设置受保护的资源阈值，超过则限制
//        rule.setCount(1);
//        // 添加到 rules 中
//        rules.add(rule);
//        FlowRuleManager.loadRules(rules);
//    }
}
