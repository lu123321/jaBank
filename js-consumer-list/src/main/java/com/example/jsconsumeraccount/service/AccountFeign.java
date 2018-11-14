package com.example.jsconsumeraccount.service;

import org.springframework.stereotype.Component;

@Component
public class AccountFeign implements AccountService {
    @Override
    public String selectOne(Integer id) {
        return "失败";
    }
}
