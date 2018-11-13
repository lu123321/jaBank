package com.cloud.jsproduceraccount.service.pojo;

import java.io.Serializable;

/**
 * (Branch)实体类
 *
 * @author makejava
 * @since 2018-11-12 10:41:38
 */
public class BranchServicepojo implements Serializable {
    private static final long serialVersionUID = 170827451523907112L;
    //网点ID
    private Integer branchId;
    //网点名称
    private String branchName;
    //网点地址
    private String branchSite;

    /*//受理业务的时间段  {"one":"00:00 - 11:11","two":"14:30 - 15:30"}
    private String branchData;
    //网点可办理业务1:预约人民币大额提现
    private Integer branchBusinessone;
    //网点可办理业务2:外币现金取款
    private Integer branchBusinesstwo;
    //经度
    private String branchLongitude;
    //维度
    private String branchDimensionality;*/


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

    /*public String getBranchData() {
        return branchData;
    }

    public void setBranchData(String branchData) {
        this.branchData = branchData;
    }

    public Integer getBranchBusinessone() {
        return branchBusinessone;
    }

    public void setBranchBusinessone(Integer branchBusinessone) {
        this.branchBusinessone = branchBusinessone;
    }

    public Integer getBranchBusinesstwo() {
        return branchBusinesstwo;
    }

    public void setBranchBusinesstwo(Integer branchBusinesstwo) {
        this.branchBusinesstwo = branchBusinesstwo;
    }

    public String getBranchLongitude() {
        return branchLongitude;
    }

    public void setBranchLongitude(String branchLongitude) {
        this.branchLongitude = branchLongitude;
    }

    public String getBranchDimensionality() {
        return branchDimensionality;
    }

    public void setBranchDimensionality(String branchDimensionality) {
        this.branchDimensionality = branchDimensionality;
    }*/

}