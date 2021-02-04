package com.gtcom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/4 10:30
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004
{
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
