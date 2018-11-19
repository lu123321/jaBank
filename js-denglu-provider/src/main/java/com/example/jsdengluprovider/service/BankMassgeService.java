package com.example.jsdengluprovider.service;


import com.example.jsdengluprovider.pojo.BankCard;

public interface BankMassgeService {
    String userSelect(Integer userid);
    String dealSelect(Integer bankcardid);
    String delCard(BankCard bankCard);
    String updateCard(Integer cardid);

    int updatePhone(String phone);

    String selectPhone(Integer userid);
}
