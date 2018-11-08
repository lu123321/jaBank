package com.cloud.dmspringzuulserver;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${token}")
    private boolean port;

    @RequestMapping("/port")
    public boolean isToken(){

        return port;
    }
}
