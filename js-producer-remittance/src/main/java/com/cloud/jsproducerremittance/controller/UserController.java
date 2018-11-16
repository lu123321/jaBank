package com.cloud.jsproducerremittance.controller;

import com.cloud.jsproducerremittance.rabbitmqUitl.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private RabbitTemplate rabbitTemplate;


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam("count")int count){
        logger.info("调用服务2" + count);
        return "调用成功2!" + count;
    }
    @RequestMapping("rabbitmq")
    public void AA(){
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_REMITTANCE,"123");
        System.out.println("fasonngchengg");
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_REMITTANCE)
    public void bb(String msg){
        System.out.println(msg);
    }
}
