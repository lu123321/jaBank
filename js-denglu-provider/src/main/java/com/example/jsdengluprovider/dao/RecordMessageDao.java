package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RecordMessageDao {
    //查看登录信息
    @Select("SELECT IPconfig from recoed where userid=#{userid}")
    List<Record> recordSelect(int userid);

    //增加IP信息
    @Insert("INSERT INTO recoed(recordid,userid,indate,IPconfig) VALUES (0,userid=#{userid},indate=#{indate},IPconfig=#{IPconfig})")
    int addRecord(Record record);
}
