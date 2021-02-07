package com.gtcom.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/5 16:12
 * @version:
 */
@Service
public class PaymentService
{
    public String paymentInfo_OK(Integer id)
    {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK,id: " + id + "\t" + "successs";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_Timeout(Integer id)
    {
        int timeout = 5;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_Timeout,id: " + id + "\t" + "successs, 耗时（s）：" + timeout;
    }

    public String paymentInfo_TimeoutHandler(Integer id)
    {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_TimeoutHandler，8001,id: " + id + "\t" + "successs, hander";
    }
    //=======服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if (id < 0)
        {
            throw  new RuntimeException("**********id 不能为负数");
        }
        String serailNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功， 流水号：" + serailNumber + " id : " + id;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能为负数，稍后再试， id: " + id;
    }
}
