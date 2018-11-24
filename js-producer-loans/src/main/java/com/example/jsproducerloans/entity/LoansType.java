package com.example.jsproducerloans.entity;

import java.io.Serializable;

/**
 * (LoansType)实体类
 *
 * @author makejava
 * @since 2018-11-20 11:01:16
 */
public class LoansType implements Serializable {
    private static final long serialVersionUID = -33822942420380545L;
    //贷款业务Id
    private Integer loansTypeid;
    //贷款业务名字
    private String loansTypename;
    //六月以下的利率
    private Double loanRatesixmon;
    //一年到六月之间的利率
    private Double loanRateoneyear;
    //一年到三年利率
    private Double loanRatethree;
    //五年到三年之间的利率
    private Double loanRatefive;
    //五年以上的利率
    private Double loanRatemore;


    public Integer getLoansTypeid() {
        return loansTypeid;
    }

    public void setLoansTypeid(Integer loansTypeid) {
        this.loansTypeid = loansTypeid;
    }

    public String getLoansTypename() {
        return loansTypename;
    }

    public void setLoansTypename(String loansTypename) {
        this.loansTypename = loansTypename;
    }

    public Double getLoanRatesixmon() {
        return loanRatesixmon;
    }

    public void setLoanRatesixmon(Double loanRatesixmon) {
        this.loanRatesixmon = loanRatesixmon;
    }

    public Double getLoanRateoneyear() {
        return loanRateoneyear;
    }

    public void setLoanRateoneyear(Double loanRateoneyear) {
        this.loanRateoneyear = loanRateoneyear;
    }

    public Double getLoanRatethree() {
        return loanRatethree;
    }

    public void setLoanRatethree(Double loanRatethree) {
        this.loanRatethree = loanRatethree;
    }

    public Double getLoanRatefive() {
        return loanRatefive;
    }

    public void setLoanRatefive(Double loanRatefive) {
        this.loanRatefive = loanRatefive;
    }

    public Double getLoanRatemore() {
        return loanRatemore;
    }

    public void setLoanRatemore(Double loanRatemore) {
        this.loanRatemore = loanRatemore;
    }
}