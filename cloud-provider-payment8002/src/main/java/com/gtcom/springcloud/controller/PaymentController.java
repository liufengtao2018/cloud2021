package com.gtcom.springcloud.controller;

import com.gtcom.springcloud.entities.CommonResult;
import com.gtcom.springcloud.entities.Payment;
import com.gtcom.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/3 10:44
 * @version:
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        log.info(payment.getSerial());
        int result = paymentService.create(payment);
        if (result > 0)
        {
            return new CommonResult(200, "插入成功，serverPort：" + serverPort, result);
        }
        else
        {
            return new CommonResult(444, "插入失败", null);
        }
    }
    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null)
        {
            return new CommonResult(200, "查询成功，serverPort：" + serverPort, payment);
        }
        else
        {
            return new CommonResult(444, "没有找到，查询ID:" + id, null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
}
