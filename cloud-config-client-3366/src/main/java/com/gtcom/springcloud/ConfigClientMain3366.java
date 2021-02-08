package com.gtcom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/8 11:33
 * @version:
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3366
{
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3366.class, args);
    }
}
