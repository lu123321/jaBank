package com.example.jsdengluprovider.service;


import com.example.jsdengluprovider.pojo.BankCard;

public interface BankLoginService {
    BankCard phoneLogin(String phone);

    BankCard cardLogin(String cardnum);

    BankCard usernameLogin(String username);

    Integer stateSelect(String cardnum);
}
