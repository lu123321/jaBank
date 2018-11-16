package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.BankCard;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

//所有信息查询
@Component
public interface BankMessageDao {
    //该用户所有卡信息
    @Select("select cardid,cardtype,cardnum,userpwd,username,webpwd,phone,state,balance,carddate,webcardstate,branchname,availablebalance from cardnumber where userid=#{userid}")
    List<BankCard> userSelect(@Param("userid") Integer userid);
    //查询该卡所有交易记录
    @Select("select dealid,dealdate,consumption,consumptionmoney,massige,payee,payeecard,transfermoney form deal where bankcardid=#{bankcardid}")
    BankCard dealSelect(@Param("bankcardid") Integer bankcardid);
    //删除卡信息
    @Delete("delete from cardnumber where cardid=#{cardid}")
    int delCard(BankCard bankCard);
    //修改该卡信息
    @Update("update cardnumber set username=#{usernam} where cardid=#{cardid}")
    int updateCard(@Param("cardid") Integer cardid);
}
