package com.example.jsproducerloans.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (LoansPay)实体类
 *
 * @author makejava
 * @since 2018-11-22 22:47:19
 */
public class LoansPay implements Serializable {
    private static final long serialVersionUID = -82045508624594850L;
    //还款id
    private Integer loansPayid;
    //贷款账单id
    private Integer loansIndentid;
    //剩余本金
    private Double loansRegbenjin;
    //已还的利息
    private Double loansLixi;


    public Integer getLoansPayid() {
        return loansPayid;
    }

    public void setLoansPayid(Integer loansPayid) {
        this.loansPayid = loansPayid;
    }

    public Integer getLoansIndentid() {
        return loansIndentid;
    }

    public void setLoansIndentid(Integer loansIndentid) {
        this.loansIndentid = loansIndentid;
    }

    public Double getLoansRegbenjin() {
        return loansRegbenjin;
    }

    public void setLoansRegbenjin(Double loansRegbenjin) {
        this.loansRegbenjin = loansRegbenjin;
    }

    public Double getLoansLixi() {
        return loansLixi;
    }

    public void setLoansLixi(Double loansLixi) {
        this.loansLixi = loansLixi;
    }
}