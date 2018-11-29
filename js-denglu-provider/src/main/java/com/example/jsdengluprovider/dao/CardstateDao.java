package com.example.jsdengluprovider.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface CardstateDao {

    //修改银行卡状态
    @Update("update cardnumber set state=#{state} where cardnum=#{cardnum}")
    int updateState(String cardnum,Integer state);

    //修改用户预留信息
    @Update("update bankuser set reservedms=#{reservedms} where userid=#{userid}")
    int updateYuliu(@Param("reservedms")String reservedms,@Param("userid")Integer userid);



}
