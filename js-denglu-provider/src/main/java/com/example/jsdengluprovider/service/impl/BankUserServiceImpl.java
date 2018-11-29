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
    //通过用户id查看用户预留号码
    @Override
    public  String getphone(String userid){
        return userMassageDao.getphone(Integer.parseInt(userid));
    }
}
