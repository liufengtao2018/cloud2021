package com.gtcom.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/5 10:45
 * @version:
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myrule()
    {
        return new RandomRule();
    }
}
