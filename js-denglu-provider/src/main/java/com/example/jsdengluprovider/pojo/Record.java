package com.example.jsdengluprovider.pojo;

import java.util.Date;

//登录记录
public class Record {
    private Integer recordid;//登录记录ID
    private Date indate;//进入时间
    private Date outtime;//退出时间
    private String IPconfig;//IP地址

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public String getIPconfig() {
        return IPconfig;
    }

    public void setIPconfig(String IPconfig) {
        this.IPconfig = IPconfig;
    }
}
