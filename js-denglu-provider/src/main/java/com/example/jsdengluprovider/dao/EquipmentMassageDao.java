package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.Equipment;
import org.apache.ibatis.annotations.*;


public interface EquipmentMassageDao {
    //设备信息查询
    @Select("select equipmentname,time,equipment from equipment where userid=#{userid}")
    Equipment equSelect(@Param("userid") Integer userid);
    //设备信息名称修改（只能修改信息名称）
    @Update("update equipment set equipmentname={equipmentname} where equipmentid=#{equipmentid}")
    int equUpdate(@Param("equipmentid") Integer equipmentid);
    //设备信息删除
    @Delete("delete from equipment where equipmentid=#{equipmentid}")
    int equDel(@Param("equipmentid") Integer equipmentid);
    //增加设备信息
    @Insert("insert into equipment(equipmentid,userid,equipmentname,time,equipment) " +
            "values(0,#{userid},#{equipmentname},#{time},#{equipment})")
    int equAdd(Equipment equipment);
}
