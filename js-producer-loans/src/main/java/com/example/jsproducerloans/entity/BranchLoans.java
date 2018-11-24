package com.example.jsproducerloans.entity;

import java.io.Serializable;

/**
 * (BranchLoans)实体类
 *
 * @author makejava
 * @since 2018-11-20 11:13:38
 */
public class BranchLoans implements Serializable {
    private static final long serialVersionUID = -16978538168056497L;
    //支行财政信息id
    private Integer branchFinancialid;
    //支行id
    private Integer branchId;
    //支行可贷款金额
    private Double branchLoansmoney;
    //质押贷款收益
    private Double branchPledgeloans;
    //个人住房贷款收益
    private Double branchHouseloans;


    public Integer getBranchFinancialid() {
        return branchFinancialid;
    }

    public void setBranchFinancialid(Integer branchFinancialid) {
        this.branchFinancialid = branchFinancialid;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Double getBranchLoansmoney() {
        return branchLoansmoney;
    }

    public void setBranchLoansmoney(Double branchLoansmoney) {
        this.branchLoansmoney = branchLoansmoney;
    }

    public Double getBranchPledgeloans() {
        return branchPledgeloans;
    }

    public void setBranchPledgeloans(Double branchPledgeloans) {
        this.branchPledgeloans = branchPledgeloans;
    }

    public Double getBranchHouseloans() {
        return branchHouseloans;
    }

    public void setBranchHouseloans(Double branchHouseloans) {
        this.branchHouseloans = branchHouseloans;
    }

}