package com.cloud.jsproduceraccount.entity;

import java.io.Serializable;

/**
 * (Detailenquiry)实体类
 *
 * @author makejava
 * @since 2018-11-10 08:50:36
 */
public class Detailenquiry implements Serializable {
    private static final long serialVersionUID = -26286492554399739L;
    //明细查询ID
    private Integer detailenquiryId;
    //卡号
    private String detailenquiryNumber;
    //交易日期
    private String detailenquiryData;
    //交易场所
    private String detailenquiryPlace;
    //摘要
    private String detailenquiryAbstract;
    //交易国家 CHN
    private String detailenquiryCountries;
    //对方信息、对方户名
    private String detailenquiryOtherinformation;
    //钞汇标志
    private String detailenquiryPaper;
    //资金流向 1 支出 2 流入
    private Integer detailenquiryFundflow;
    //余额
    private String detailenquiryBalance;
    //交易币种 
    private Integer detailenquiryTransactioncurrency;
    //交易金额
    private Object detailenquiryMoney;


    public Integer getDetailenquiryId() {
        return detailenquiryId;
    }

    public void setDetailenquiryId(Integer detailenquiryId) {
        this.detailenquiryId = detailenquiryId;
    }

    public String getDetailenquiryNumber() {
        return detailenquiryNumber;
    }

    public void setDetailenquiryNumber(String detailenquiryNumber) {
        this.detailenquiryNumber = detailenquiryNumber;
    }

    public String getDetailenquiryData() {
        return detailenquiryData;
    }

    public void setDetailenquiryData(String detailenquiryData) {
        this.detailenquiryData = detailenquiryData;
    }

    public String getDetailenquiryPlace() {
        return detailenquiryPlace;
    }

    public void setDetailenquiryPlace(String detailenquiryPlace) {
        this.detailenquiryPlace = detailenquiryPlace;
    }

    public String getDetailenquiryAbstract() {
        return detailenquiryAbstract;
    }

    public void setDetailenquiryAbstract(String detailenquiryAbstract) {
        this.detailenquiryAbstract = detailenquiryAbstract;
    }

    public String getDetailenquiryCountries() {
        return detailenquiryCountries;
    }

    public void setDetailenquiryCountries(String detailenquiryCountries) {
        this.detailenquiryCountries = detailenquiryCountries;
    }

    public String getDetailenquiryOtherinformation() {
        return detailenquiryOtherinformation;
    }

    public void setDetailenquiryOtherinformation(String detailenquiryOtherinformation) {
        this.detailenquiryOtherinformation = detailenquiryOtherinformation;
    }

    public String getDetailenquiryPaper() {
        return detailenquiryPaper;
    }

    public void setDetailenquiryPaper(String detailenquiryPaper) {
        this.detailenquiryPaper = detailenquiryPaper;
    }

    public Integer getDetailenquiryFundflow() {
        return detailenquiryFundflow;
    }

    public void setDetailenquiryFundflow(Integer detailenquiryFundflow) {
        this.detailenquiryFundflow = detailenquiryFundflow;
    }

    public String getDetailenquiryBalance() {
        return detailenquiryBalance;
    }

    public void setDetailenquiryBalance(String detailenquiryBalance) {
        this.detailenquiryBalance = detailenquiryBalance;
    }

    public Integer getDetailenquiryTransactioncurrency() {
        return detailenquiryTransactioncurrency;
    }

    public void setDetailenquiryTransactioncurrency(Integer detailenquiryTransactioncurrency) {
        this.detailenquiryTransactioncurrency = detailenquiryTransactioncurrency;
    }

    public Object getDetailenquiryMoney() {
        return detailenquiryMoney;
    }

    public void setDetailenquiryMoney(Object detailenquiryMoney) {
        this.detailenquiryMoney = detailenquiryMoney;
    }

}