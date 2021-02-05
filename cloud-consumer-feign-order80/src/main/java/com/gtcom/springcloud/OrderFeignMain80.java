package com.gtcom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/5 14:24
 * @version:
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80
{
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
