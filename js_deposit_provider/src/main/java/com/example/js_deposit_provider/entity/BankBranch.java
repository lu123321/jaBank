package com.example.js_deposit_provider.entity;

import java.io.Serializable;

/**
 * (BankBranch)实体类
 *
 * @author makejava
 * @since 2018-11-08 10:36:06
 */
public class BankBranch implements Serializable {
    private static final long serialVersionUID = -64132076184269887L;
    //支行id
    private Integer branchId;
    //支行名字
    private String branchName;
    //支行进度
    private String branch_longitude;
    //支行纬度
    private String branch_latitude;


    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranch_longitude() {
        return branch_longitude;
    }

    public void setBranch_longitude(String branch_longitude) {
        this.branch_longitude = branch_longitude;
    }

    public String getBranch_latitude() {
        return branch_latitude;
    }

    public void setBranch_latitude(String branch_latitude) {
        this.branch_latitude = branch_latitude;
    }

}