package com.example.jsproducerloans.service.pojo;

import java.io.Serializable;

public class DaiKuai implements Serializable {
    private Double money; //金额
    private  String cardid; //卡号
    private  String businessName;//业务名字
    private  int state; //业务类型
    private  int informid;//订单id

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getInformid() {
        return informid;
    }

    public void setInformid(int informid) {
        this.informid = informid;
    }
}
