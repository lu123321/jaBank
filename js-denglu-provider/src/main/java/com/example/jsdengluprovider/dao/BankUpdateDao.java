package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.BankUser;
import org.apache.ibatis.annotations.Update;

public interface BankUpdateDao {
    @Update("update bankuser set province,city,jingpwd,birthday,married,educatri,occupation,industry,skill,administrative," +
            "")
    int bankUpdate(BankUser bankUser);
}
