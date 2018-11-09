package com.cloud.dmspringproducerserver.entity;

import java.io.Serializable;

/**
 * (Branch)实体类
 *
 * @author makejava
 * @since 2018-11-08 22:02:39
 */
public class Branch implements Serializable {
    private static final long serialVersionUID = -19421228223440849L;
    //网点ID
    private Integer branchId;
    //网点名称
    private String branchName;
    //网点地址
    private String branchSite;
    //受理业务的时间段  {"one":"00:00 - 11:11","two":"14:30 - 15:30"}
    private String branchData;
    //冗余列
    private String branchOne;


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

    public String getBranchSite() {
        return branchSite;
    }

    public void setBranchSite(String branchSite) {
        this.branchSite = branchSite;
    }

    public String getBranchData() {
        return branchData;
    }

    public void setBranchData(String branchData) {
        this.branchData = branchData;
    }

    public String getBranchOne() {
        return branchOne;
    }

    public void setBranchOne(String branchOne) {
        this.branchOne = branchOne;
    }

}