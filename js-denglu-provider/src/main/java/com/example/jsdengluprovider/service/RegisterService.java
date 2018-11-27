package com.example.jsdengluprovider.service;

import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.pojo.BankUser;

import java.util.List;

public interface RegisterService {


    String addBankCard(BankUser bankuser,BankCard bankcard);

    void addBankUser(BankUser bankuser);

    List<BankCard> selectOne(String phone);

    boolean selectState(String idcard);

    boolean a(BankUser bankuser);

    boolean b(BankCard bankcard);

    String selectCard(String cardnum,String idcard,String phone);





}
