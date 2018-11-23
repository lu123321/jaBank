package com.example.jsdengluprovider.pojo;

import com.example.jsdengluprovider.util.date.DateUtil;

import java.util.Date;

//登录记录
public class Record {
    private Integer recordid;//登录记录ID
    private Integer userid;
    private String indate;//进入时间
    private String outtime;//退出时间
    private String IPconfig;//IP地址

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getIndate() {
        return DateUtil.SchangeD(indate);
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }


    public String getOuttime() {
        return outtime;
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
