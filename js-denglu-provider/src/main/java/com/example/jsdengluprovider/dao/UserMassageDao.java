package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.BankUser;

//修改信息
public interface UserMassageDao {
    //修改个人信息
    int updatUser(BankUser bankUser);
    //删除个人信息
    int delUser(BankUser bankUser);
}
