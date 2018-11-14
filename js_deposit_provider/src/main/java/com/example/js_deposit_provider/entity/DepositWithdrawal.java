package com.example.js_deposit_provider.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DepositWithdrawal)实体类
 *
 * @author makejava
 * @since 2018-11-12 19:45:09
 */
public class DepositWithdrawal implements Serializable {
    private static final long serialVersionUID = 773752315334472942L;
    //取款记录id
    private Integer depositWithdrawalid;
    //取款对应的订单号
    private Integer depositWithdrawalorderid;
    //取款发起时间
    private Date depositWithdrawalintime;
    //取出时间
    private Date depositWithdrawaouttime;
    //取出金额
    private Integer depositWithdrawalmoney;
    //取款状态  0未完成，1已完成
    private Integer depositWithdrawalstate;
    //用户id
    private  Integer depositWithdrawalUserId;

    public Integer getDepositWithdrawalUserId() {
        return depositWithdrawalUserId;
    }

    public void setDepositWithdrawalUserId(Integer depositWithdrawalUserId) {
        this.depositWithdrawalUserId = depositWithdrawalUserId;
    }

    public Integer getDepositWithdrawalid() {
        return depositWithdrawalid;
    }

    public void setDepositWithdrawalid(Integer depositWithdrawalid) {
        this.depositWithdrawalid = depositWithdrawalid;
    }

    public Integer getDepositWithdrawalorderid() {
        return depositWithdrawalorderid;
    }

    public void setDepositWithdrawalorderid(Integer depositWithdrawalorderid) {
        this.depositWithdrawalorderid = depositWithdrawalorderid;
    }

    public Date getDepositWithdrawalintime() {
        return depositWithdrawalintime;
    }

    public void setDepositWithdrawalintime(Date depositWithdrawalintime) {
        this.depositWithdrawalintime = depositWithdrawalintime;
    }

    public Date getDepositWithdrawaouttime() {
        return depositWithdrawaouttime;
    }

    public void setDepositWithdrawaouttime(Date depositWithdrawaouttime) {
        this.depositWithdrawaouttime = depositWithdrawaouttime;
    }

    public Integer getDepositWithdrawalmoney() {
        return depositWithdrawalmoney;
    }

    public void setDepositWithdrawalmoney(Integer depositWithdrawalmoney) {
        this.depositWithdrawalmoney = depositWithdrawalmoney;
    }

    public Integer getDepositWithdrawalstate() {
        return depositWithdrawalstate;
    }

    public void setDepositWithdrawalstate(Integer depositWithdrawalstate) {
        this.depositWithdrawalstate = depositWithdrawalstate;
    }

}