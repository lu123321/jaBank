package com.example.jsdengluprovider.service;


import com.example.jsdengluprovider.pojo.BankCard;

public interface BankLoginService {
    BankCard phoneLogin(String phone);

    BankCard cardLogin(String cardnum);

    BankCard usernameLogin(String username);

    Integer stateSelect(String cardnum);

    Integer stateSelect1(String phone);

    Integer stateSelect2(String username);

    String selectState(String cardnum);

    String selectState1(String phone);

    String selectState2(String username);
}
