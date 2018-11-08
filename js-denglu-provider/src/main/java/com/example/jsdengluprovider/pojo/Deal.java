package com.example.jsdengluprovider.pojo;

import java.util.Date;

public class Deal {
    private Integer dealid;
    private Date dealdate;//交易日期
    private String consumption;//消费类型
    private Double consumptionmoney;//交易金额
    private String massige;//对方信息
    private String payee;//收款人
    private String payeecard;//收款人卡号
    private Double transfermoney;//转账金额

    public Double getTransfermoney() {
        return transfermoney;
    }

    public void setTransfermoney(Double transfermoney) {
        this.transfermoney = transfermoney;
    }

    public Integer getDealid() {
        return dealid;
    }

    public void setDealid(Integer dealid) {
        this.dealid = dealid;
    }

    public Date getDealdate() {
        return dealdate;
    }

    public void setDealdate(Date dealdate) {
        this.dealdate = dealdate;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public Double getConsumptionmoney() {
        return consumptionmoney;
    }

    public void setConsumptionmoney(Double consumptionmoney) {
        this.consumptionmoney = consumptionmoney;
    }

    public String getMassige() {
        return massige;
    }

    public void setMassige(String massige) {
        this.massige = massige;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPayeecard() {
        return payeecard;
    }

    public void setPayeecard(String payeecard) {
        this.payeecard = payeecard;
    }
}
