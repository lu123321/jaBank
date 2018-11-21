package com.cloud.jsproducerremittance.rabbitmqUitl;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    //触发汇款接口   发送消息给瀚文  进行金额变更  单笔汇款
    public static final String QUEUE_REMITTANCE = "QUEUE_REMITTANCE";
    //批量汇款
    public static final String QUEUE_BATCH = "QUEUE_BATCH";
    @Bean
    public Queue queue(){
        return new Queue(QUEUE_REMITTANCE,true,false,false);
    }
    @Bean
    public Queue queueBa(){
        return new Queue(QUEUE_BATCH,true,false,false);
    }
}
