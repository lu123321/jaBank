package com.example.jsdengluprovider.service.impl;

import com.example.jsdengluprovider.dao.BankLoginDao;
import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.pojo.Equipment;
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
    public BankCard phoneLogin(String phone) {
        return bankLoginDao.phoneLogin(phone);
    }

    @Override
    public BankCard cardLogin(String cardnum) {
        return bankLoginDao.cardLogin(cardnum);
    }

    @Override
    public BankCard usernameLogin(String username) {

        return bankLoginDao.usernameLogin(username);
    }

    @Override
    public Integer stateSelect(String cardnum) {

        return bankLoginDao.stateSelect(cardnum);
    }

}
