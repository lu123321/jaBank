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

    @Override
    public Integer stateSelect1(String phone) {
        return bankLoginDao.stateSelect1(phone);
    }

    @Override
    public Integer stateSelect2(String username) {
        return bankLoginDao.stateSelect2(username);
    }

    @Override
    public String selectState(String cardnum) {
        return bankLoginDao.selectState(cardnum);
    }

    @Override
    public String selectState1(String phone) {
        return bankLoginDao.selectState1(phone);
    }

    @Override
    public String selectState2(String username) {
        return bankLoginDao.selectState2(username);
    }

}
