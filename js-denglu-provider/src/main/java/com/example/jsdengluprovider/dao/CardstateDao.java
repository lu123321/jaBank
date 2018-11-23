package com.example.jsdengluprovider.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface CardstateDao {

    //修改卡状态
    @Update("UPDATE cardnumber SET state=#{state} where userid=#{userid} and cardnum=#{cardnum}")
    int updateState(@Param("userid") Integer userid, @Param("cardnum") String cardnum);
}
