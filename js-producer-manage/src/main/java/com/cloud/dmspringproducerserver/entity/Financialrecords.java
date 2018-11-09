package com.cloud.dmspringproducerserver.entity;

import java.io.Serializable;

/**
 * (Financialrecords)实体类
 *
 * @author makejava
 * @since 2018-11-08 22:11:15
 */
public class Financialrecords implements Serializable {
    private static final long serialVersionUID = 527401994854920383L;
    //理财产品交易记录表ID
    private Integer financialrecordsId;
    //理财产品ID
    private Integer financialrecordsManageid;
    //交易时间
    private String financialrecordsData;
    //购买的金额
    private String financialrecordsMoney;
    //购买产品的用户ID
    private Integer financialrecordsUserid;


    public Integer getFinancialrecordsId() {
        return financialrecordsId;
    }

    public void setFinancialrecordsId(Integer financialrecordsId) {
        this.financialrecordsId = financialrecordsId;
    }

    public Integer getFinancialrecordsManageid() {
        return financialrecordsManageid;
    }

    public void setFinancialrecordsManageid(Integer financialrecordsManageid) {
        this.financialrecordsManageid = financialrecordsManageid;
    }

    public String getFinancialrecordsData() {
        return financialrecordsData;
    }

    public void setFinancialrecordsData(String financialrecordsData) {
        this.financialrecordsData = financialrecordsData;
    }

    public String getFinancialrecordsMoney() {
        return financialrecordsMoney;
    }

    public void setFinancialrecordsMoney(String financialrecordsMoney) {
        this.financialrecordsMoney = financialrecordsMoney;
    }

    public Integer getFinancialrecordsUserid() {
        return financialrecordsUserid;
    }

    public void setFinancialrecordsUserid(Integer financialrecordsUserid) {
        this.financialrecordsUserid = financialrecordsUserid;
    }

}