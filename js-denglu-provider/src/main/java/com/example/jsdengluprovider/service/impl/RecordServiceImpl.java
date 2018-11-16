package com.example.jsdengluprovider.service.impl;

import com.example.jsdengluprovider.dao.RecordMessageDao;
import com.example.jsdengluprovider.pojo.Record;
import com.example.jsdengluprovider.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class RecordServiceImpl implements RecordService {

    @Resource
    private RecordMessageDao rm;

    InetAddress addr;
    String ip = null;

    {
        try {
            addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addRecord(Integer userid) {
        System.out.println(userid);
        Record r = new Record();
            r.setUserid(userid);
            r.setIPconfig(ip);
            rm.addRecord(r);
    }

    @Override
    public String selectRecord(Integer userid) {

        String s = rm.recordSelect(userid);
        if(s != null){
            return "1";
        }else {
            return "0";
        }
    }
}
