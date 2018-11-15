package com.example.jsdengluprovider.pojo;

import com.example.jsdengluprovider.util.date.DateUtil;

import java.util.Date;

//登录记录
public class Record {
    private Integer recordid;//登录记录ID
    private String indate;//进入时间
    private String outtime;//退出时间
    private String IPconfig;//IP地址

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public Date getIndate() {
        return DateUtil.SchangeD(indate);
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public Date getOuttime() {
        return DateUtil.SchangeD(outtime);
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }

    public String getIPconfig() {
        return IPconfig;
    }

    public void setIPconfig(String IPconfig) {
        this.IPconfig = IPconfig;
    }
}
