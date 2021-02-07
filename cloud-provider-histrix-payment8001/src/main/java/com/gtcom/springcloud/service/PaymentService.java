package com.gtcom.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
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
}
