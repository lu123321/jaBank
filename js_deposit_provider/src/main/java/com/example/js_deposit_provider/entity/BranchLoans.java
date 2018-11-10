package com.example.js_deposit_provider.entity;

import java.io.Serializable;

/**
 * (BranchLoans)实体类
 *
 * @author makejava
 * @since 2018-11-08 10:34:03
 */
public class BranchLoans implements Serializable {
    private static final long serialVersionUID = -19602184863250052L;
    //支行财政信息id
    private Integer branchFinancialid;
    //支行id
    private Integer branchId;
    //支行可贷款金额
    private String branchLoansmoney;
    //质押贷款收益
    private String branchPledgeloans;
    //个人住房贷款收益
    private String branchHouseloans;


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

    public String getBranchLoansmoney() {
        return branchLoansmoney;
    }

    public void setBranchLoansmoney(String branchLoansmoney) {
        this.branchLoansmoney = branchLoansmoney;
    }

    public String getBranchPledgeloans() {
        return branchPledgeloans;
    }

    public void setBranchPledgeloans(String branchPledgeloans) {
        this.branchPledgeloans = branchPledgeloans;
    }

    public String getBranchHouseloans() {
        return branchHouseloans;
    }

    public void setBranchHouseloans(String branchHouseloans) {
        this.branchHouseloans = branchHouseloans;
    }

}