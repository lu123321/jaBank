package com.example.jsproduceroptions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JsProducerOptionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsProducerOptionsApplication.class, args);
    }
}
