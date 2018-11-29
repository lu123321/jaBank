package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.BankUser;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface BankUpdateDao {
    //修改网银预留信息
    @Update("update bankuser set reservedms=#{reservedms} where userid=#{userid}")
    int bankUpdate(BankUser bankUser);


}
