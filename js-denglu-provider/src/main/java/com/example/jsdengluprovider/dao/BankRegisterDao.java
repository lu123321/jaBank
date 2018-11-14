package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.pojo.BankUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BankRegisterDao {
    @Insert("insert into cardnumber(cardid,cardtype,cardnum,userpwd,userid,phone,state,balance,carddate,webcardstate,branchname," +
            "availablebalance) VALUES (0,#{cardtype},#{cardnum},#{userpwd},#{userid},#{phone},#{state},#{balance},#{carddate},#{webcardstate},#{branchname},#{availablebalance})")
    int addBankcard(BankCard bankcard);

    @Insert("insert into bankuser(userid,name,idcard,province,city,imgurl,credit,jingpwd,sex,birthday," +
            "people,work,webstate,reservedms) values(0,#{name},#{idcard},#{province},#{city}," +
            "#{imgurl},#{credit},#{jingpwd},#{sex},#{birthday},#{people},#{work},#{webstate},#{reservedms})")
    int addBankuser(BankUser bankuser);

    @Select("select webcardstate from cardnumber where phone=#{phone}")
    String selectOne(String phone);

    @Select("select webstate from bankuser where idcard=#{idcard}")
    String selectState(String idcard);

    @Update("update cardnumber set   where phone=#{phone}")
    int updateBank();
}
