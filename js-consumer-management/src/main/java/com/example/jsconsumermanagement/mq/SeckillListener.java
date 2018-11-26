package com.example.jsconsumermanagement.mq;


import org.springframework.stereotype.Component;


@Component
public class SeckillListener {

//   @RabbitListener(queues = {RabbitConfig.QUEUE_PHONE})
    public void receive(String msg){
       System.out.println(msg);
   }
}
