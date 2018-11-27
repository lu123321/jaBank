package com.example.jsdengluprovider.pojo;

import java.io.Serializable;

//登录设备信息
public class Equipment implements Serializable{
    private Integer userid;
    private Integer equipmentid;//设备ID
    private String equipmentname;//设备名称
    private String time;//绑定时间
    private String IPconfig;
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

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

    public String getTime(){
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIPconfig() {
        return IPconfig;
    }

    public void setIPconfig(String IPconfig) {
        this.IPconfig = IPconfig;
    }
}
