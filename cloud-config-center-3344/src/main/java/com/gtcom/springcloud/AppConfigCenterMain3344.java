package com.gtcom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/8 10:03
 * @version:
 */
@SpringBootApplication
@EnableConfigServer
public class AppConfigCenterMain3344
{
    public static void main(String[] args) {
        SpringApplication.run(AppConfigCenterMain3344.class, args);
    }
}
