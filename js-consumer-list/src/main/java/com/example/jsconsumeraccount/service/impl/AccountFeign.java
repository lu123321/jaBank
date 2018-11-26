package com.example.jsconsumeraccount.service.impl;

import com.example.jsconsumeraccount.service.AccountService;
import org.springframework.stereotype.Component;

@Component
public class AccountFeign implements AccountService {
    @Override
    public String selectOne(Integer id) {
        return "失败";
    }

    @Override
    public String liss(Integer id) {
        return "查询失败";
    }

/*    @Override
    public String comsumeid(Integer id) {
        return "失败";
    }*/
}
