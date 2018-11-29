package com.example.jsdengluprovider.service;


import com.example.jsdengluprovider.pojo.BankCard;

public interface BankMassgeService {
    String userSelect(Integer userid);
    String dealSelect(Integer bankcardid);
    String delCard(BankCard bankCard);
    String updateCard(Integer cardid);
    int updatePhone(String phone);
    String selectPhone(Integer userid);
    String selectAll(Integer userid);
    //根据用户id查询用户的所有储蓄卡信息
    String getAllCard(String userid);
    //根据卡id查询用户的卡余额
    String getbalance(String cardid);
}
