package com.example.jsdengluprovider.service;

import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.pojo.BankUser;


public interface BankLoginService {
    String iphoneLogin(String iphone, String webpwd);
    String cardLogin(String cardnum, String webpwd);
    String usernameLogin(String username,String webpwd);
}
