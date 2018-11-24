package com.example.js_deposit_provider.service.pojo;

/**
 * 取款返回实体类
 */
public class Qukuan {
    private Double money; //金额
    private  String cardid; //卡号
    private  String businessName;//业务名字
    private  int state; //业务类型

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }


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
}
