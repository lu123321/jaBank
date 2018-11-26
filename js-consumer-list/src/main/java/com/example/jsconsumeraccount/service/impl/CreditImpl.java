package com.example.jsconsumeraccount.service.impl;

import com.example.jsconsumeraccount.service.CreditService;
import org.springframework.stereotype.Component;

@Component
public class CreditImpl implements CreditService {
    @Override
    public String comsumeid(Integer id) {
        return "未能查询到信息";
    }
}
