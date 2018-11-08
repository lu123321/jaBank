package com.example.js_deposit_provider.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DepositBig)实体类
 *
 * @author makejava
 * @since 2018-11-08 10:32:26
 */
public class DepositBig implements Serializable {
    private static final long serialVersionUID = 201390292086359737L;
    //大额存款id
    private Integer depositBigid;
    //订单号
    private String depositBignumber;
    //存款对应卡号
    private String depositBigcardid;
    //转入金额
    private String depositBigmoney;
    //存入的本金和利息和
    private String depositBigmoneyandinter;
    //大额存款业务名
    private String depositBigbusname;
    //存入时间
    private Date depositBigintime;
    //存的时长
    private String depositBiglong;
    //到期时间
    private Date depositBigouttime;


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

    public String getDepositBigmoney() {
        return depositBigmoney;
    }

    public void setDepositBigmoney(String depositBigmoney) {
        this.depositBigmoney = depositBigmoney;
    }

    public String getDepositBigmoneyandinter() {
        return depositBigmoneyandinter;
    }

    public void setDepositBigmoneyandinter(String depositBigmoneyandinter) {
        this.depositBigmoneyandinter = depositBigmoneyandinter;
    }

    public String getDepositBigbusname() {
        return depositBigbusname;
    }

    public void setDepositBigbusname(String depositBigbusname) {
        this.depositBigbusname = depositBigbusname;
    }

    public Date getDepositBigintime() {
        return depositBigintime;
    }

    public void setDepositBigintime(Date depositBigintime) {
        this.depositBigintime = depositBigintime;
    }

    public String getDepositBiglong() {
        return depositBiglong;
    }

    public void setDepositBiglong(String depositBiglong) {
        this.depositBiglong = depositBiglong;
    }

    public Date getDepositBigouttime() {
        return depositBigouttime;
    }

    public void setDepositBigouttime(Date depositBigouttime) {
        this.depositBigouttime = depositBigouttime;
    }

}