package com.cloud.dmspringproducerserver.entity;

import java.io.Serializable;

/**
 * (Currencytable)实体类
 *
 * @author makejava
 * @since 2018-11-08 22:11:34
 */
public class Currencytable implements Serializable {
    private static final long serialVersionUID = -95101465836180588L;
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