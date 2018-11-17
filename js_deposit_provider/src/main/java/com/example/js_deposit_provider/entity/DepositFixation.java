package com.example.js_deposit_provider.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DepositFixation)实体类
 *
 * @author makejava
 * @since 2018-11-08 10:32:29
 */
public class DepositFixation implements Serializable {
    private static final long serialVersionUID = 344416194865490079L;
    //定额存款Id
    private Integer depositFixationid;
    //定期存款订单号
    private String depositFixationnumber;
    //定期存款管理卡号
    private String depositFixationcardid;
    //定期存款存入金额
    private Double depositFixationmoney;
    //定期存款本金和利息
    private Double deposit_fixationLv;
    //通知存款业务名称
    private String depositFixationbusinesstype;
    //定期存款存入时间
    private Date depositFixationintime;
    //通知存款到期时间
    private Date depositFixationouttime;
    //通知存款用户id
    private Integer depositFixationuserid;
    //定期存款状态
    private  Integer depositState;

    public Integer getDepositState() {
        return depositState;
    }

    public void setDepositState(Integer depositState) {
        this.depositState = depositState;
    }

    public Integer getDepositFixationid() {
        return depositFixationid;
    }

    public void setDepositFixationid(Integer depositFixationid) {
        this.depositFixationid = depositFixationid;
    }

    public String getDepositFixationnumber() {
        return depositFixationnumber;
    }

    public void setDepositFixationnumber(String depositFixationnumber) {
        this.depositFixationnumber = depositFixationnumber;
    }

    public String getDepositFixationcardid() {
        return depositFixationcardid;
    }

    public void setDepositFixationcardid(String depositFixationcardid) {
        this.depositFixationcardid = depositFixationcardid;
    }

    public Double getDepositFixationmoney() {
        return depositFixationmoney;
    }

    public void setDepositFixationmoney(Double depositFixationmoney) {
        this.depositFixationmoney = depositFixationmoney;
    }

    public Double getDeposit_fixationLv() {
        return deposit_fixationLv;
    }

    public void setDeposit_fixationLv(Double deposit_fixationLv) {
        this.deposit_fixationLv = deposit_fixationLv;
    }

    public String getDepositFixationbusinesstype() {
        return depositFixationbusinesstype;
    }

    public void setDepositFixationbusinesstype(String depositFixationbusinesstype) {
        this.depositFixationbusinesstype = depositFixationbusinesstype;
    }

    public Date getDepositFixationintime() {
        return depositFixationintime;
    }

    public void setDepositFixationintime(Date depositFixationintime) {
        this.depositFixationintime = depositFixationintime;
    }

    public Date getDepositFixationouttime() {
        return depositFixationouttime;
    }

    public void setDepositFixationouttime(Date depositFixationouttime) {
        this.depositFixationouttime = depositFixationouttime;
    }

    public Integer getDepositFixationuserid() {
        return depositFixationuserid;
    }

    public void setDepositFixationuserid(Integer depositFixationuserid) {
        this.depositFixationuserid = depositFixationuserid;
    }

}