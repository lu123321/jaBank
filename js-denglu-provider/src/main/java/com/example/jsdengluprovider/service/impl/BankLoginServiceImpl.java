package com.example.jsdengluprovider.service.impl;

import com.example.jsdengluprovider.dao.BankLoginDao;
import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.service.BankLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BankLoginServiceImpl implements BankLoginService {
    @Resource
    private BankLoginDao bankLoginDao;

    public BankLoginDao getBankLoginDao() {
        return bankLoginDao;
    }

    public void setBankLoginDao(BankLoginDao bankLoginDao) {
        this.bankLoginDao = bankLoginDao;
    }

    @Override
    public BankCard phoneLogin(String phone, String webpwd) {
        return bankLoginDao.phoneLogin(phone,webpwd);
    }

    @Override
    public BankCard cardLogin(String cardnum, String webpwd) {
        return bankLoginDao.cardLogin(cardnum,webpwd);
    }

    @Override
    public BankCard usernameLogin(String username, String webpwd) {
        return bankLoginDao.usernameLogin(username,webpwd);
    }
}
