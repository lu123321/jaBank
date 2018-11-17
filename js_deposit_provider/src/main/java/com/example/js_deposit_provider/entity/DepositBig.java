package com.example.js_deposit_provider.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DepositBig)实体类
 *
 * @author makejava
 * @since 2018-11-16 19:58:52
 */
public class DepositBig implements Serializable {
    private static final long serialVersionUID = -96233921769151993L;
    //大额存款id
    private Integer depositBigid;
    //订单号
    private String depositBignumber;
    //存款对应卡号
    private String depositBigcardid;
    //转入金额
    private Double depositBigmoney;
    //存入的本金和利息和
    private Double depositBiglv;
    //大额存款业务名
    private Integer depositBigbustype;
    //存入时间
    private Date depositBigintime;
    //存的时长
    private Integer depositBiglong;
    //到期时间
    private Date depositBigouttime;
    
    private Integer depositBiguserid;
    private  Integer depositBigState;

    public Integer getDepositBigState() {
        return depositBigState;
    }

    public void setDepositBigState(Integer depositBigState) {
        this.depositBigState = depositBigState;
    }

    public Integer getDepositBigid() {
        return depositBigid;
    }

    public void setDepositBigid(Integer depositBigid) {
        this.depositBigid = depositBigid;
    }

    public String getDepositBignumber() {
        return depositBignumber;
    }

    public void setDepositBignumber(String depositBignumber) {
        this.depositBignumber = depositBignumber;
    }

    public String getDepositBigcardid() {
        return depositBigcardid;
    }

    public void setDepositBigcardid(String depositBigcardid) {
        this.depositBigcardid = depositBigcardid;
    }

    public Double getDepositBigmoney() {
        return depositBigmoney;
    }

    public void setDepositBigmoney(Double depositBigmoney) {
        this.depositBigmoney = depositBigmoney;
    }

    public Double getDepositBiglv() {
        return depositBiglv;
    }

    public void setDepositBiglv(Double depositBiglv) {
        this.depositBiglv = depositBiglv;
    }

    public Integer getDepositBigbustype() {
        return depositBigbustype;
    }

    public void setDepositBigbustype(Integer depositBigbustype) {
        this.depositBigbustype = depositBigbustype;
    }

    public Date getDepositBigintime() {
        return depositBigintime;
    }

    public void setDepositBigintime(Date depositBigintime) {
        this.depositBigintime = depositBigintime;
    }

    public Integer getDepositBiglong() {
        return depositBiglong;
    }

    public void setDepositBiglong(Integer depositBiglong) {
        this.depositBiglong = depositBiglong;
    }

    public Date getDepositBigouttime() {
        return depositBigouttime;
    }

    public void setDepositBigouttime(Date depositBigouttime) {
        this.depositBigouttime = depositBigouttime;
    }

    public Integer getDepositBiguserid() {
        return depositBiguserid;
    }

    public void setDepositBiguserid(Integer depositBiguserid) {
        this.depositBiguserid = depositBiguserid;
    }

}