package com.example.jsdengluprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JsDengluProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsDengluProviderApplication.class, args);
    }
}
