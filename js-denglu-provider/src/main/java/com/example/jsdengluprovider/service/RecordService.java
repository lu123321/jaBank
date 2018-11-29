package com.example.jsdengluprovider.service;


import com.example.jsdengluprovider.pojo.Record;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface RecordService {

    void addRecord(Integer userid, HttpServletRequest request);

    String selectRecord(String IPconfig);

    List<Record> selectAll(Integer userid);

    void addEquipment(Integer userid,HttpServletRequest request);


    /**
     * 忘记密码
     */
    String selectXinxi(String name,String idcard);
    String selectCard(String cardnum,String userpwd);
    String updateUserpwd(String webpwd,Integer userid);



}
