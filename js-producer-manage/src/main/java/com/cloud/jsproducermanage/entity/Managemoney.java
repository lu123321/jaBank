package com.cloud.jsproducermanage.entity;

import java.io.Serializable;

/**
 * (Managemoney)实体类
 *
 * @author makejava
 * @since 2018-11-10 08:52:38
 */
public class Managemoney implements Serializable {
    private static final long serialVersionUID = -70976247198549872L;
    //理财产品ID
    private Integer managemoneyId;
    //产品名称
    private String managemoneyName;
    //预期年化收益率
    private String managemoneyYield;
    //起购金额
    private String managemoneyPurchase;
    //期限
    private String managemoneyDeadline;
    //种类  关联理财产品种类表
    private Integer managemoneyCategory;
    //发售日期
    private String managemoneyReleasedate;
    //理财产品库存
    private Integer managemoneyRepertory;


    public Integer getManagemoneyId() {
        return managemoneyId;
    }

    public void setManagemoneyId(Integer managemoneyId) {
        this.managemoneyId = managemoneyId;
    }

    public String getManagemoneyName() {
        return managemoneyName;
    }

    public void setManagemoneyName(String managemoneyName) {
        this.managemoneyName = managemoneyName;
    }

    public String getManagemoneyYield() {
        return managemoneyYield;
    }

    public void setManagemoneyYield(String managemoneyYield) {
        this.managemoneyYield = managemoneyYield;
    }

    public String getManagemoneyPurchase() {
        return managemoneyPurchase;
    }

    public void setManagemoneyPurchase(String managemoneyPurchase) {
        this.managemoneyPurchase = managemoneyPurchase;
    }

    public String getManagemoneyDeadline() {
        return managemoneyDeadline;
    }

    public void setManagemoneyDeadline(String managemoneyDeadline) {
        this.managemoneyDeadline = managemoneyDeadline;
    }

    public Integer getManagemoneyCategory() {
        return managemoneyCategory;
    }

    public void setManagemoneyCategory(Integer managemoneyCategory) {
        this.managemoneyCategory = managemoneyCategory;
    }

    public String getManagemoneyReleasedate() {
        return managemoneyReleasedate;
    }

    public void setManagemoneyReleasedate(String managemoneyReleasedate) {
        this.managemoneyReleasedate = managemoneyReleasedate;
    }

    public Integer getManagemoneyRepertory() {
        return managemoneyRepertory;
    }

    public void setManagemoneyRepertory(Integer managemoneyRepertory) {
        this.managemoneyRepertory = managemoneyRepertory;
    }

}