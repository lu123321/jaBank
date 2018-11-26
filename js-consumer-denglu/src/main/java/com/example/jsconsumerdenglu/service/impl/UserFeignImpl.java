package com.example.jsconsumerdenglu.service.impl;


import com.example.jsconsumerdenglu.feign.UserFeign;
import org.springframework.stereotype.Component;

@Component
public class UserFeignImpl implements UserFeign{
    public String login(String name){
        return "错误" + name;
    }

    @Override
    public String login(int conut) {
        System.out.println("asdasd");
        return "错误" +conut;
    }
}
