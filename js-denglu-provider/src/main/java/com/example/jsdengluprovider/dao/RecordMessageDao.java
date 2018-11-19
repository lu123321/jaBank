package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface RecordMessageDao {
    //查看登录信息
    @Select("SELECT IPconfig from recoed where userid=#{userid}")
    String recordSelect(@Param("userid") int userid);

    //增加IP信息
    @Insert("INSERT INTO recoed(userid,IPconfig) VALUES (#{userid},#{IPconfig})")
    int addRecord( Record record);

    //通过用户ID查到手机号码
    @Select("select phone from cardnumber where userid=#{userid}")
    String selectPhone(@Param("userid") Integer userid);



}
