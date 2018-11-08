package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.Deal;

import java.util.List;

public interface DealMessageDao {
    //查询该卡交易金额
    List<Deal> dealSelect();
}
