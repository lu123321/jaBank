package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.Equipment;
import org.apache.ibatis.annotations.Select;


public interface EquipmentMassageDao {
    //设备信息查询
    @Select("select equipmentname,time,equipment from equipment where userid=#{userid}")
    Equipment equSelect();
    //设备信息名称修改（只能修改信息名称）
    int equUpdate(Integer equname);
    //设备信息删除
    int equDel(Equipment equipment);
}
