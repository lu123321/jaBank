package com.example.jsconsumermanagement.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static final String QUEUE_WITHDRAWAL = "Queue_Withdrawal";//发送秒杀订单队列
    public static final String QUEUE_DEPOSIT = "QUEUE_deposit";//存款队列
    public static final String QUEUE_PHONE = "QUEUE_PHONE";
    @Bean
    public Queue seckillOrderQueue() {
        return new Queue(QUEUE_WITHDRAWAL);
    }

    @Bean
    public Queue seckillLoserQueue() {
        return new Queue(QUEUE_DEPOSIT);
    }

    @Bean
    public Queue phoneQueue() {
        return new Queue(QUEUE_PHONE);
    }
}
