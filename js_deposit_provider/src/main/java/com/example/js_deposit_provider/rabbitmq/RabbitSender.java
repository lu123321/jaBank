package com.example.js_deposit_provider.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.BlockingQueueConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RabbitSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void sendSeckillOrderQueue(String message) {
//        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_SECKILL_ORDER, message);
    }
}
