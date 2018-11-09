package com.cloud.dmspringproducerserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam("name")String name){
        return "调用成功3!" + name;
    }

}
