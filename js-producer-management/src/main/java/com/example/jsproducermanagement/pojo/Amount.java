package com.example.jsproducermanagement.pojo;

public class Amount {
    private Integer userId;
    private Double singlePay;
    private Double trojanPay;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getSinglePay() {
        return singlePay;
    }

    public void setSinglePay(Double singlePay) {
        this.singlePay = singlePay;
    }

    public Double getTrojanPay() {
        return trojanPay;
    }

    public void setTrojanPay(Double trojanPay) {
        this.trojanPay = trojanPay;
    }
}
