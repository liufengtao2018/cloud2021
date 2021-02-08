package com.gtcom.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/8 15:15
 * @version:
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController
{
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message)
    {
        System.out.println("消费者8803， 接收消息： " + message.getPayload() + "\t port: " + serverPort);
    }
}
