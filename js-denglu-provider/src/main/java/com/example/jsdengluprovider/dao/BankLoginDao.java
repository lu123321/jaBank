package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.BankCard;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//登录
@Component
public interface BankLoginDao {
    //银行预留手机号登录
    @Select("select phone,webpwd from cardnumber where phone=#{phone}")
    BankCard phoneLogin(@Param("phone") String phone);
    //银行卡号登录
    @Select("select cardnum,webpwd from cardnumber where cardnum=#{cardnum}")
    BankCard cardLogin(@Param("cardnum") String cardnum);
    //用户名登录
    @Select("select username,webpwd from cardnumber where username=#{username}")
    BankCard usernameLogin(@Param("username") String username);
    //查询网银状态
    @Select("select webcardstate from cardnumber where cardnum=#{cardnum}")
    Integer stateSelect(@Param("cardnum")String cardnum);
}
