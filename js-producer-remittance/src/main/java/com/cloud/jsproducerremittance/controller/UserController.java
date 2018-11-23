package com.cloud.jsproducerremittance.controller;

import com.cloud.jsproducerremittance.rabbitmqUitl.RabbitConfig;
import com.cloud.jsproducerremittance.uitl.RedisUtil;
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
    @Resource
    private RedisUtil redisUtil;

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

//    @RabbitListener(queues = RabbitConfig.QUEUE_REMITTANCE)
    public void bb(String msg){
        System.out.println(msg);
    }

    @RequestMapping("/textredis")
    public String text(String number ,String price){
        if (redisUtil.get("remitt" + number) == null){
            redisUtil.set("remitt" + number,price,30);
            return "null ok";
        }else{
            Double doo = Double.parseDouble(redisUtil.get("remitt" + number).toString());
            long expire = redisUtil.getExpire("remitt" + number);
            Double a = doo + Double.parseDouble(price);
            if (a > 40000){
                return "今日汇款已限额!最多累加40000.00!" + "剩余过期时间" + expire;
            }
            redisUtil.set("remitt" + number,a.toString(),expire);
            return "操作后" + a + "剩余过期时间" + expire;
        }
    }

    @RequestMapping("/getredis")
    public String tee(String number){
        return redisUtil.get("remitt" + number).toString();
    }

    String a;
    @RequestMapping("/asd")
    public void a(){
        System.out.println(a);
    }
}
