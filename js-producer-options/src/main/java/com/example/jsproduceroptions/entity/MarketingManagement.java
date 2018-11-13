package com.example.jsproduceroptions.entity;

import java.io.Serializable;

/**
 * (MarketingManagement)实体类
 *
 * @author makejava
 * @since 2018-11-08 16:01:17
 */
public class MarketingManagement implements Serializable {
    private static final long serialVersionUID = 129453568316045977L;
    //用户id
    private Integer userId;
    //序号
    private Integer number;
    //姓名
    private String name;
    //营销代码
    private String marketing;
    //联系电话
    private String phone;
    //是否默认(0是默认；1不默认)
    private Integer state;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarketing() {
        return marketing;
    }

    public void setMarketing(String marketing) {
        this.marketing = marketing;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}