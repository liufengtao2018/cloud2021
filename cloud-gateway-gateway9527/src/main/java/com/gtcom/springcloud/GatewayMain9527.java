package com.gtcom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/7 16:24
 * @version:
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527
{
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }
}
