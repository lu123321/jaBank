package com.cloud.dmspringzuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class DmSpringZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmSpringZuulServerApplication.class, args);
    }

//    @Bean
//    public PreFilter preFilter(){
//
//        return new PreFilter();
//    }
}
