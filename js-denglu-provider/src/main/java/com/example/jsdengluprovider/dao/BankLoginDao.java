package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.BankCard;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

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

    //银行卡登录获取此卡状态
    @Select("select state from cardnumber where cardnum=#{cardnum}")
    String selectState(@Param("cardnum")String cardnum);
    //手机号登录获取此卡状态
    @Select("select state from cardnumber where phone=#{phone}")
    String selectState1(@Param("phone")String phone);
    //用户名登录获取此卡状态
    @Select("select state from cardnumber where username=#{username}")
    String selectState2(@Param("username")String username);


}
