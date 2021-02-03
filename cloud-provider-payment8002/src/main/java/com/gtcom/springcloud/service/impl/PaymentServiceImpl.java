package com.gtcom.springcloud.service.impl;

import com.gtcom.springcloud.dao.PaymentDao;
import com.gtcom.springcloud.entities.Payment;
import com.gtcom.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/3 10:35
 * @version:
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
