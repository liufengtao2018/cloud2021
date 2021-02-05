package com.gtcom.springcloud.controller;

import com.gtcom.springcloud.entities.CommonResult;
import com.gtcom.springcloud.entities.Payment;
import com.gtcom.springcloud.lb.MyLB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/3 14:04
 * @version:
 */
@RestController
@Slf4j
public class OrderController {
//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private MyLB myLB;

    @PostMapping("consumer/payment/create")
    public CommonResult<Payment> create(Payment payment)
    {
        log.info(payment.getSerial());
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getServerPort()
    {
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instances = myLB.instances(serviceInstanceList);
        return restTemplate.getForObject(instances.getUri() + "/payment/lb", String.class);
    }
}
