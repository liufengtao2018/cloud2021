package com.gtcom.springcloud;

import com.gtcom.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/3 13:41
 * @version:
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderMain80
{
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
