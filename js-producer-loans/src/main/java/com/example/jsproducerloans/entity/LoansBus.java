package com.example.jsproducerloans.entity;

import java.io.Serializable;

/**
 * (LoansBus)实体类
 *
 * @author makejava
 * @since 2018-11-20 11:01:16
 */
public class LoansBus implements Serializable {
    private static final long serialVersionUID = 257382337270070735L;
    //业务id
    private Integer loansBusid;
    //业务名
    private String loansBusname;
    //类型id
    private Integer loansTypeid;


    public Integer getLoansBusid() {
        return loansBusid;
    }

    public void setLoansBusid(Integer loansBusid) {
        this.loansBusid = loansBusid;
    }

    public String getLoansBusname() {
        return loansBusname;
    }

    public void setLoansBusname(String loansBusname) {
        this.loansBusname = loansBusname;
    }

    public Integer getLoansTypeid() {
        return loansTypeid;
    }

    public void setLoansTypeid(Integer loansTypeid) {
        this.loansTypeid = loansTypeid;
    }

}