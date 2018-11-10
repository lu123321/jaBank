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
    @Select("select phone,webpwd from cardnumber where phone=#{phone} and webpwd=#{webpwd}")
    BankCard phoneLogin(@Param("phone") String phone, @Param("webpwd") String webpwd);
    //银行卡号登录
    @Select("select cardnum,webpwd from cardnumber where cardnum=#{cardnum} and webpwd=#{webpwd}")
    BankCard cardLogin(@Param("cardnum") String cardnum,@Param("webpwd") String webpwd);
    //用户名登录
    @Select("select username,webpwd from where username=#{username} and webpwd=#{webpwd}")
    BankCard usernameLogin(@Param("username") String username,@Param("webpwd") String webpwd);
}
