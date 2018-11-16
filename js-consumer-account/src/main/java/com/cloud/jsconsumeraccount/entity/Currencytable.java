package com.cloud.jsconsumeraccount.entity;

import java.io.Serializable;

/**
 * (Currencytable)实体类
 *
 * @author makejava
 * @since 2018-11-12 22:18:07
 */
public class Currencytable implements Serializable {
    private static final long serialVersionUID = 834351855221703213L;
    //币种ID
    private Integer currencytableId;
    //币种昵称 
    private String currencytableName;


    public Integer getCurrencytableId() {
        return currencytableId;
    }

    public void setCurrencytableId(Integer currencytableId) {
        this.currencytableId = currencytableId;
    }

    public String getCurrencytableName() {
        return currencytableName;
    }

    public void setCurrencytableName(String currencytableName) {
        this.currencytableName = currencytableName;
    }

}