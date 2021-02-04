package com.gtcom.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/4 15:23
 * @version:
 */
@RestController
@Slf4j
public class PaymentConsulController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentconsul()
    {
        return "springcloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
