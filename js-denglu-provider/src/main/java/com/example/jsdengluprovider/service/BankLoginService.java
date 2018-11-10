package com.example.jsdengluprovider.service;


import com.example.jsdengluprovider.pojo.BankCard;

public interface BankLoginService {
    BankCard phoneLogin(String phone, String webpwd);
    BankCard cardLogin(String cardnum, String webpwd);
    BankCard usernameLogin(String username, String webpwd);
}
