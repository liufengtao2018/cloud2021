package com.gtcom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/3 16:14
 * @version:
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 
{
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
