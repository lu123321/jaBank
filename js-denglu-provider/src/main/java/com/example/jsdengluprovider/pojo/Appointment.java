package com.example.jsdengluprovider.pojo;

import java.util.Date;

//预约信息
public class Appointment {
    private Integer appointmentid;//预约ID
    private String type;//预约类型
    private String state;//预约状态
    private Date time;//预约时间

    public Integer getAppointmentid() {
        return appointmentid;
    }

    public void setAppointmentid(Integer appointmentid) {
        this.appointmentid = appointmentid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
