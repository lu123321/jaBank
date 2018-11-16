package com.cloud.jsproducermanage.entity;

import java.io.Serializable;

/**
 * (Currencytable)实体类
 *
 * @author makejava
 * @since 2018-11-10 08:53:36
 */
public class Currencytable implements Serializable {
    private static final long serialVersionUID = -28914579684931105L;
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