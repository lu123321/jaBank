package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.BankUser;
import org.apache.ibatis.annotations.Update;

public interface BankUpdateDao {
    @Update("")
    int bankUpdate(BankUser bankUser);
}
