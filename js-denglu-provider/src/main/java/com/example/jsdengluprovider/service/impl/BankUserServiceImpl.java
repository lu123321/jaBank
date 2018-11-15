package com.example.jsdengluprovider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsdengluprovider.dao.UserMassageDao;
import com.example.jsdengluprovider.service.BankUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BankUserServiceImpl implements BankUserService {
    @Resource
    private UserMassageDao userMassageDao;
    @Override
    public String userSelect(Integer userid) {
        return JSON.toJSONString(userMassageDao.userSelect(userid));
    }
}
