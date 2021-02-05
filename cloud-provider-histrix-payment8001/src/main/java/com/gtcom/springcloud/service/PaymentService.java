package com.gtcom.springcloud.service;

import org.springframework.stereotype.Component;
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

    public String paymentInfo_Timeout(Integer id)
    {
        int timeout = 3;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_Timeout,id: " + id + "\t" + "successs, 耗时（s）：" + timeout;
    }
}
