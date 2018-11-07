package com.example.js_deposit_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JsDepositProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsDepositProviderApplication.class, args);
    }
}
