package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.BankCard;
import org.apache.ibatis.annotations.Select;

//登录
public interface BankLoginDao {
    //银行预留手机号登录
    @Select("select phone,webpwd from cardnumber where phone=#{phone} and webpwd=#{webpwd}")
    BankCard phoneLogin(String phone,String webpwd);
    //银行卡号登录
    @Select("select cardnum,webpwd from cardnumber where cardnum=#{cardnum} and webpwd=#{webpwd}")
    BankCard cardLogin(String cardnum,String webpwd);
    //用户名登录
    @Select("select username,webpwd from where username=#{username} and webpwd=#{webpwd}")
    BankCard usernameLogin(String username,String webpwd);
}
