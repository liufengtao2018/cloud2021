package com.gtcom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/4 13:26
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain80 
{
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain80.class, args);
    }
}
