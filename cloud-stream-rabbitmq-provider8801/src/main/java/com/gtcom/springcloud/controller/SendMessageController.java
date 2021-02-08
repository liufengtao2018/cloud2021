package com.gtcom.springcloud.controller;

import com.gtcom.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/8 15:00
 * @version:
 */
@RestController
public class SendMessageController
{
    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage()
    {
        return iMessageProvider.send();
    }
}
