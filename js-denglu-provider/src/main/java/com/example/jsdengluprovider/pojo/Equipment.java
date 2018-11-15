package com.example.jsdengluprovider.pojo;

import com.example.jsdengluprovider.util.date.DateUtil;

import java.util.Date;

//登录设备信息
public class Equipment {
    private Integer equipmentid;//设备ID
    private String equipmentname;//设备名称
    private String time;//绑定时间
    private String equipment;//设备登录支付类型

    public Integer getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(Integer equipmentid) {
        this.equipmentid = equipmentid;
    }

    public String getEquipmentname() {
        return equipmentname;
    }

    public void setEquipmentname(String equipmentname) {
        this.equipmentname = equipmentname;
    }

    public Date getTime() {
        return DateUtil.SchangeD(time);
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}
