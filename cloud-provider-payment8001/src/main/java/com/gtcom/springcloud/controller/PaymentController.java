package com.gtcom.springcloud.controller;

import com.gtcom.springcloud.entities.CommonResult;
import com.gtcom.springcloud.entities.Payment;
import com.gtcom.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping(value="/payment/create")
    public CommonResult create(Payment payment)
    {
        log.info(payment.getSerial());
        int result = paymentService.create(payment);
        if (result > 0)
        {
            return new CommonResult(200, "插入成功", result);
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
            return new CommonResult(200, "查询成功", payment);
        }
        else
        {
            return new CommonResult(444, "没有找到，查询ID:" + id, null);
        }
    }
}
