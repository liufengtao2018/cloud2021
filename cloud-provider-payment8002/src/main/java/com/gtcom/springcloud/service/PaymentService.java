package com.gtcom.springcloud.service;

import com.gtcom.springcloud.entities.Payment;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/3 10:34
 * @version:
 */
public interface PaymentService
{
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
