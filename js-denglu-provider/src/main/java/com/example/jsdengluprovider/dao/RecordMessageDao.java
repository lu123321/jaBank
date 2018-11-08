package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.Record;

public interface RecordMessageDao {
    //查看登录信息
    Record recordSelect(int userid);
}
