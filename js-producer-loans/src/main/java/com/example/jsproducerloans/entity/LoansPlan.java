package com.example.jsproducerloans.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (LoansPlan)实体类
 *
 * @author makejava
 * @since 2018-11-22 21:32:47
 */
public class LoansPlan implements Serializable {
    private static final long serialVersionUID = -36804740188489856L;
    //还款计划id
    private Integer loansPlanid;
    //订单id
    private Integer loansPlaninformid;
    //还款时间
    private Date loansPlantime;
    //还款金额
    private Double loansPlanmoney;
    //本期还款所还的利息
    private Double loansPlanlixi;
    //还款状态
    private Integer loansState;
    //应还本金
    private Double loansBenjin;
    private Double loansYuqiMoney;
    //逾期时长
    private Integer loansOverlong;

    public Integer getLoansOverlong() {
        return loansOverlong;
    }

    public void setLoansOverlong(Integer loansOverlong) {
        this.loansOverlong = loansOverlong;
    }

    public Double getLoansYuqiMoney() {
        return loansYuqiMoney;
    }

    public void setLoansYuqiMoney(Double loansYuqiMoney) {
        this.loansYuqiMoney = loansYuqiMoney;
    }

    public Integer getLoansPlanid() {
        return loansPlanid;
    }

    public void setLoansPlanid(Integer loansPlanid) {
        this.loansPlanid = loansPlanid;
    }

    public Integer getLoansPlaninformid() {
        return loansPlaninformid;
    }

    public void setLoansPlaninformid(Integer loansPlaninformid) {
        this.loansPlaninformid = loansPlaninformid;
    }

    public Date getLoansPlantime() {
        return loansPlantime;
    }

    public void setLoansPlantime(Date loansPlantime) {
        this.loansPlantime = loansPlantime;
    }

    public Double getLoansPlanmoney() {
        return loansPlanmoney;
    }

    public void setLoansPlanmoney(Double loansPlanmoney) {
        this.loansPlanmoney = loansPlanmoney;
    }

    public Integer getLoansState() {
        return loansState;
    }

    public void setLoansState(Integer loansState) {
        this.loansState = loansState;
    }

    public Double getLoansPlanlixi() {
        return loansPlanlixi;
    }

    public void setLoansPlanlixi(Double loansPlanlixi) {
        this.loansPlanlixi = loansPlanlixi;
    }

    public Double getLoansBenjin() {
        return loansBenjin;
    }

    public void setLoansBenjin(Double loansBenjin) {
        this.loansBenjin = loansBenjin;
    }
}