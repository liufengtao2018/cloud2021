package com.gtcom.springcloud.controller;

import com.gtcom.springcloud.entities.CommonResult;
import com.gtcom.springcloud.entities.Payment;
import com.gtcom.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/5 14:39
 * @version:
 */
@RestController
@Slf4j
public class OrderPaymentFeignCotroller {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id)
    {
        return paymentFeignService.getPayment(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        return paymentFeignService.paymentFeignTimeout();
    }
}
