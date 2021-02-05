package com.gtcom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/5 8:43
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain80
{
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain80.class, args);
    }
}
