package com.example.jsdengluprovider.service.pojo;

import java.io.Serializable;

public class CardEntity implements Serializable {
    private Integer cardId; //卡id
    private String CardNumber; //卡号
    private Double balance;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }
}
