package com.example.jsdengluprovider.service;

import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.pojo.BankUser;

public interface RegisterService {
    String addBankuser(BankUser bankuser,BankCard bankcard);

    void addBankcard(BankCard bankcard);

    String updateBank(BankCard bankcard);

    boolean selectOne(String phone);

    boolean selectState(String idcard);

    boolean a(BankUser bankuser,BankCard bankcard);

    boolean b(BankCard bankcard);
}
