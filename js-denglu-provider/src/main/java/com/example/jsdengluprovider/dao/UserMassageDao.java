package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.BankUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;


//修改信息
@Component
public interface UserMassageDao {
    //查询个人所有信息
    @Select("select name,idcard,province,city,imgurl,credit,jingpwd,sex,birthday,married,education,occupation,industry,skill,administrative,people,work,worktime,reservedms,faststate,idcarddate,e_mail,tallage,integral from bankuser where userid=#{userid}")
    BankUser userSelect(@Param("userid") Integer userid);
    //修改个人信息
    @Update("update bankuser set birthday=#{birthday},married=#{married},education=#{education},occupation=#{occupation},industry=#{industry},skill=#{skill},administrative=#{administrative},people=#{people},work=#{work},worktime=#{worktime} where userid=#{userid}")
    int updatUser(BankUser bankUser);
    //删除个人信息

    int delUser(BankUser bankUser);

    /**
     * 通过用户id查看用户预留手机号
     * @param userid
     * @return
     */
    @Select("select userphone from bankuser   where userid=#{userid}")
    String getphone(@Param("userid") int userid);


    /**
     * 通过用户ID查找该用户的身份证
     * @param userid
     * @return
     */
    @Select("select idcard from bankuser where userid=#{userid}")
    String selectIncard(@Param("userid") Integer userid);




}
