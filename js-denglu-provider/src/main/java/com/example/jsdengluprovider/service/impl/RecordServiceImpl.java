package com.example.jsdengluprovider.service.impl;

import com.example.jsdengluprovider.dao.RecordMessageDao;
import com.example.jsdengluprovider.pojo.Equipment;
import com.example.jsdengluprovider.pojo.Record;
import com.example.jsdengluprovider.service.RecordService;
import com.example.jsdengluprovider.util.IPUtil.IpUtil;
import com.example.jsdengluprovider.util.date.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Resource
    private RecordMessageDao rm;


    //添加用户每次登录信息
    @Override
    public void addRecord(Integer userid, HttpServletRequest request) {
        Record r = new Record();
            r.setUserid(userid);
            r.setIPconfig(IpUtil.getIpAddr(request));
            rm.addRecord(r);
    }

    @Override
    public String selectRecord(String IPconfig) {

        int s = rm.recordSelect(IPconfig);
        if(s != 0){
            return "1";
        }else {
            return "0";
        }
    }

    @Override
    public List<Record> selectAll(Integer userid) {
        List<Record> records = rm.selectAll(userid);
        return records;
    }

    //添加用户在陌生设备上登录信息
    @Override
    public void addEquipment(Integer userid,HttpServletRequest request) {
        Equipment e = new Equipment();
        e.setEquipmentid(0);
        e.setUserid(userid);
        String nowDateTime = DateUtil.getNowDateTime();
        e.setTime(nowDateTime);
        e.setEquipmentname("电脑");
        e.setIPconfig(IpUtil.getIpAddr(request));
        rm.addEquipment(e);
    }
}
