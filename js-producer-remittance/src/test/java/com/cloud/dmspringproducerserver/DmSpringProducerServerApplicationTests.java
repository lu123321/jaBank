package com.cloud.dmspringproducerserver;

import com.cloud.jsproducerremittance.rabbitmqUitl.RabbitConfig;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DmSpringProducerServerApplicationTests {

    public static void main(String[] args) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        Integer a = 1;
        String b = a + "";
        System.out.println(b);
        /*String str = "[\\u4e00-\\u9fa5]+";
        String aa = "^\\d{19}$";
        boolean matches = "6212549236542565845".matches(aa);
        System.out.println(matches);*/

    }
}
