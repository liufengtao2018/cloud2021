package com.gtcom.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/7 14:01
 * @version:
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "fallback-PaymentFallbackService-paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "fallback-PaymentFallbackService-paymentInfo_Timeout";
    }
}
