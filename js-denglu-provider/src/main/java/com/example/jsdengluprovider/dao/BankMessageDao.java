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

    //修改手机号码信息
    @Update("update cardnumber set phone=#{phone} where cardnum=#{cardnum}")
    int updatePhone(@Param("phone") String phone,@Param("cardnum") String cardnum);

    //通过用户id和是否开通网银查找卡号
    @Select("select cardnum from cardnumber where userid=#{userid} and webcardstate=#{webcardstate}")
    String selectCardnum(@Param("userid") Integer userid,@Param("webcardstate") Integer webcardstate);

    //通过selectCardnum()找到该卡的手机号码
    @Select("select phone from cardnumber where cardnum=#{cardnum}")
    String selectPhone(@Param("cardnum") String cardnum);

    //显示该用户的所有银行卡&&显示该卡余额
    @Select("select cardnum,balance from cardnumber where userid=#{userid}")
    List<BankCard> selectAll(@Param("userid") Integer userid);
    //根据用户id查看所有的储蓄卡信息
    @Select("select cardid,cardnum,balance from cardnumber where  userid=#{userid} and cardtype=1")
    List<BankCard> getAllCard(@Param("userid") Integer userid);

    //通过卡id查询余额
    @Select("select balance from cardnumber where cardid=#{cardid}")
    Double getbalance(@Param("cardid") int cardid);

}
