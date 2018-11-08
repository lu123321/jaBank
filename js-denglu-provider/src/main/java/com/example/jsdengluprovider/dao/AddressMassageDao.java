package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.Address;

public interface AddressMassageDao {
    //常用地址查询
    Address addSelect(int cardid);
    //常用地址删除
    int delAddress(Address address);
    //常用地址修改
    int updateAddress(Address address);
    //常用地址增加
    int addAddress(Address address);
}
