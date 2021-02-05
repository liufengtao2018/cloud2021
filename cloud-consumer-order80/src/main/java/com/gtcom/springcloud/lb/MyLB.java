package com.gtcom.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/5 11:36
 * @version:
 */
@Component
@Slf4j
public class MyLB implements LoadBalance {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private final int getAndIncement()
    {
        for (;;)
        {
            int current = atomicInteger.get() == Integer.MAX_VALUE?0:atomicInteger.get();
            int next = current + 1;
            if (atomicInteger.compareAndSet(current, next))
            {
                log.info("**********第" + next + "次访问");
            }
            return next;
        }
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
