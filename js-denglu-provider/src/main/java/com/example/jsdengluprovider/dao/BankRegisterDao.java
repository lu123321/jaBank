package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.pojo.BankUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankRegisterDao {
    @Insert("insert into cardnumber(cardid,cardtype,cardnum,userpwd,userid,phone,state,balance,carddate,webcardstate,branchname," +
            "availablebalance) VALUES (0,#{cardtype},#{cardnum},#{userpwd},#{userid},#{phone},#{state},#{balance},#{carddate},#{webcardstate},#{branchname},#{availablebalance})")
    int addBankcard(BankCard bankcard);

    @Insert("insert into bankuser(userid,name,idcard,province,city,imgurl,credit,jingpwd,sex,birthday," +
            "people,work,reservedms) values(0,#{name},#{idcard},#{province},#{city}," +
            "#{imgurl},#{credit},#{jingpwd},#{sex},#{birthday},#{people},#{work},#{reservedms})")
    int addBankuser(BankUser bankuser);
    //通过手机号码找到银行卡
    @Select("select cardnum from cardnumber where phone=#{phone}")
    List<BankCard> selectOne(@Param("phone") String phone);

    //通过银行卡判断是否已开通
    @Select("select webcardstate from cardnumber where cardnum=#{cardnum} and state=0")
    String selectCard(@Param("cardnum")String cardnum);

    //通过银行卡查找手机号码
    @Select("select phone from cardnumber where cardnum=#{cardnum} and state=0")
    String selectPhone(@Param("cardnum")String cardnum);

    //通过银行卡以及该银行卡状态查询用户ID，通过用户ID找到该用户身份证。
    @Select("select userid from cardnumber where cardnum=#{cardnum} and state=0")
    String selectUserid(@Param("cardnum")String cardnum);

    //通过id查找用户身份信息
    @Select("select idcard from bankuser where userid=#{userid}")
    String selectIdcard(@Param("userid")Integer userid);

    //通过银行卡修改网银状态
    @Update("update cardnumber set webcardstate=1 where cardnum=#{cardnum}")
    int updateState(@Param("cardnum")String cardnum);


    @Select("select webstate from bankuser where idcard=#{idcard}")
    String selectState(String idcard);

    @Select("select count(1) from cardnumber where cardnum=#{cardnum}")
    String selectCardnum(@Param("cardnum") String cardnum);

}
