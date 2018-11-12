package com.example.js_deposit_provider.service.pojo;

/**
 * 取款返回实体类
 */
public class Qukuan {
    private String money; //金额
    private  String cardid; //卡号

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }
}
