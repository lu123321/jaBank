package com.example.jsproducerloans.util;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitConfig {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static final String QUEUE_WITHDRAWAL = "Queue_Withdrawal";//发送秒杀订单队列
    public static final String QUEUE_DEPOSIT = "QUEUE_deposit";//存款队列
    public static final String QUEUE_GETYUE = "Queue_getyue"; //查余额队列
    public static final String QUEUE_YUERETURN = "QUEUE_YUERETURN";//查余额返回队列
    @Bean
    public Queue seckillOrderQueue() {
        return new Queue(QUEUE_WITHDRAWAL);
    }
    @Bean
    public Queue seckillLoserQueue() {
        return new Queue(QUEUE_DEPOSIT);
    }
    @Bean
    public Queue seckillYueeQueue(){
        return new Queue(QUEUE_GETYUE);
    }
    @Bean
    public Queue seckillreturnQueue(){
        return new Queue(QUEUE_YUERETURN);
    }
}
