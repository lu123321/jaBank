package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.pojo.BankUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.security.PermitAll;

//登录
@Component
public interface BankLoginDao {
    //银行预留手机号登录
    @Select("select phone,webpwd,userid from cardnumber where phone=#{phone}")
    BankCard phoneLogin(@Param("phone") String phone);
    //银行卡号登录
    @Select("select cardnum,webpwd,userid from cardnumber where cardnum=#{cardnum}")
    BankCard cardLogin(@Param("cardnum") String cardnum);
    //用户名登录
    @Select("select username,webpwd,userid from cardnumber where username=#{username}")
    BankCard usernameLogin(@Param("username") String username);
    //查询网银状态
    @Select("select webcardstate from cardnumber where cardnum=#{cardnum}")
    Integer stateSelect(@Param("cardnum")String cardnum);
    //查询网银状态
    @Select("select webcardstate from cardnumber where phone=#{phone}")
    Integer stateSelect1(@Param("phone")String phone);
    //查询网银状态
    @Select("select webcardstate from cardnumber where username=#{username}")
    Integer stateSelect2(@Param("username")String username);

}
