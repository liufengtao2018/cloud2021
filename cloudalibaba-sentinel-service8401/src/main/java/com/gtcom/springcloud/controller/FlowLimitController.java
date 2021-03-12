package com.gtcom.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/3/12 9:49
 * @version:
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping(value = "testA")
    public String testA()
    {
        return "-------------testA";
    }
    @GetMapping(value = "testB")
    public String testB()
    {
        return "-------------testB";
    }

    @GetMapping("/testC")
    @SentinelResource(value = "testC", blockHandler = "deal_testC")
    public String testC(@RequestParam(name = "p1", required = false) String p1,
                        @RequestParam(name = "p2", required = false) String p2)
    {
        return "-------------testC";
    }

    public String deal_testC(String p1, String p2, BlockedException exception)
    {
        return "-------------testC, block";
    }
}
