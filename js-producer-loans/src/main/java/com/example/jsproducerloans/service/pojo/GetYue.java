package com.example.jsproducerloans.service.pojo;

import java.io.Serializable;

public class GetYue implements Serializable {
    private String card; //卡号
    private int planid; //订单id
    private double money; //需还金额
    private Integer state; //卡余额扣除状态


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public int getPlanid() {
        return planid;
    }

    public void setPlanid(int planid) {
        this.planid = planid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
