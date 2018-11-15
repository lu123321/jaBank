package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.BankUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


//修改信息
public interface UserMassageDao {
    //查询个人所有信息
    @Select("select name,idcard,province,city,imgurl,credit,jingpwd,sex,birthday,married,education,occupation,industry,skill,administrative,people,work,worktime,webstate,reservedms,faststate,idcarddate,e_mail,tallage,integral from bankuser where userid=#{userid}")
    BankUser userSelect(@Param("userid") Integer userid);
    //修改个人信息
    @Update("")
    int updatUser(BankUser bankUser);
    //删除个人信息
    int delUser(BankUser bankUser);
}
