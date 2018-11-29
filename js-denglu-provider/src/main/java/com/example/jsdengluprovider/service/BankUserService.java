package com.example.jsdengluprovider.service;

public interface BankUserService {
    String userSelect(Integer userid);
    //通过用户id查看用户预留手机号
    String getphone(String userid);
}
