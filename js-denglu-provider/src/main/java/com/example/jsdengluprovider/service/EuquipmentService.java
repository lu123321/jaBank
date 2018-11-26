package com.example.jsdengluprovider.service;

import com.example.jsdengluprovider.pojo.Equipment;

public interface EuquipmentService {
    String equSelect(Integer userid);
    String equUpdate(Integer equipmentid);
    String equDel(Integer equipmentid);
    String equAdd(Equipment equipment);
}
