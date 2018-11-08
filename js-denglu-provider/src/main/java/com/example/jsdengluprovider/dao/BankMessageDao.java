package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.BankCard;

import java.util.List;

//所有信息查询
public interface BankMessageDao {
    //该用户所有卡信息
    List<BankCard> userSelect(String name);
    //查询该卡所有交易记录
    BankCard dealSelect(String cardnum);
    //删除卡信息
    int delCard(BankCard bankCard);
    //修改该卡信息
    int updateCard(BankCard bankCard);
}
