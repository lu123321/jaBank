package com.example.js_deposit_provider.rabbitmq;


import com.alibaba.fastjson.JSON;
import com.example.js_deposit_provider.service.pojo.Qukuan;
import org.apache.commons.lang.SerializationUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Queue;


@Component
public class SeckillListener {

   @RabbitListener(queues = {RabbitConfig.QUEUE_WITHDRAWAL})
    public void receive(String msg){
       List<Qukuan> q = JSON.parseArray(msg,Qukuan.class);
       for (Qukuan a : q){
           System.out.println(a.getMoney());
       }
   }
}
