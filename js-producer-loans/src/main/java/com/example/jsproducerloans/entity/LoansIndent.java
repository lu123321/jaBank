package com.example.jsproducerloans.entity;

import java.io.Serializable;

/**
 * (LoansIndent)实体类
 *
 * @author makejava
 * @since 2018-11-17 17:23:31
 */
public class LoansIndent implements Serializable {
    private static final long serialVersionUID = 526601769937437315L;
    //贷款订单id
    private Integer loansIndentid;
    //贷款人
    private Integer loansUserid;
    //订单号
    private String loansIndentnumber;
    //贷款金额
    private Double loansMoney;
    //贷款时长
    private Integer loansLong;
    //还款方式
    private Integer loansRefund;
    //订单状态
    private Integer loansState;
    //贷款合同信息
    private String loansContract;
    //贷款类型
    private Integer loansType;
    
    private String loanscard;
    
    private Double loanslixi;


    public Integer getLoansIndentid() {
        return loansIndentid;
    }

    public void setLoansIndentid(Integer loansIndentid) {
        this.loansIndentid = loansIndentid;
    }

    public Integer getLoansUserid() {
        return loansUserid;
    }

    public void setLoansUserid(Integer loansUserid) {
        this.loansUserid = loansUserid;
    }

    public String getLoansIndentnumber() {
        return loansIndentnumber;
    }

    public void setLoansIndentnumber(String loansIndentnumber) {
        this.loansIndentnumber = loansIndentnumber;
    }

    public Double getLoansMoney() {
        return loansMoney;
    }

    public void setLoansMoney(Double loansMoney) {
        this.loansMoney = loansMoney;
    }

    public Integer getLoansLong() {
        return loansLong;
    }

    public void setLoansLong(Integer loansLong) {
        this.loansLong = loansLong;
    }

    public Integer getLoansRefund() {
        return loansRefund;
    }

    public void setLoansRefund(Integer loansRefund) {
        this.loansRefund = loansRefund;
    }

    public Integer getLoansState() {
        return loansState;
    }

    public void setLoansState(Integer loansState) {
        this.loansState = loansState;
    }

    public String getLoansContract() {
        return loansContract;
    }

    public void setLoansContract(String loansContract) {
        this.loansContract = loansContract;
    }

    public Integer getLoansType() {
        return loansType;
    }

    public void setLoansType(Integer loansType) {
        this.loansType = loansType;
    }

    public String getLoanscard() {
        return loanscard;
    }

    public void setLoanscard(String loanscard) {
        this.loanscard = loanscard;
    }

    public Double getLoanslixi() {
        return loanslixi;
    }

    public void setLoanslixi(Double loanslixi) {
        this.loanslixi = loanslixi;
    }
}