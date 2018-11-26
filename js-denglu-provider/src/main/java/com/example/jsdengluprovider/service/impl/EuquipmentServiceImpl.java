package com.example.jsdengluprovider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsdengluprovider.dao.EquipmentMassageDao;
import com.example.jsdengluprovider.pojo.Equipment;
import com.example.jsdengluprovider.service.EuquipmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EuquipmentServiceImpl implements EuquipmentService {

    @Resource
    private EquipmentMassageDao equipmentMassageDao;
    @Override
    public String equSelect(Integer userid) {
        return JSON.toJSONString(equipmentMassageDao.equSelect(userid));
    }

    @Override
    public String equUpdate(Integer equipmentid) {
        return JSON.toJSONString(equipmentMassageDao.equUpdate(equipmentid));
    }

    @Override
    public String equDel(Integer equipmentid) {
        return JSON.toJSONString(equipmentMassageDao.equDel(equipmentid));
    }

    @Override
    public String equAdd(Equipment equipment) {
        return JSON.toJSONString(equipmentMassageDao.equAdd(equipment));
    }
}
