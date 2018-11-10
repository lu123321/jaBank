package com.example.js_deposit_provider.entity;

import java.io.Serializable;

/**
 * (DepositType)实体类
 *
 * @author makejava
 * @since 2018-11-08 10:32:29
 */
public class DepositType implements Serializable {
    private static final long serialVersionUID = -60349377149894959L;
    //存款类型id
    private Integer depositTypeid;
    //存款类型名字
    private String depositTypename;


    public Integer getDepositTypeid() {
        return depositTypeid;
    }

    public void setDepositTypeid(Integer depositTypeid) {
        this.depositTypeid = depositTypeid;
    }

    public String getDepositTypename() {
        return depositTypename;
    }

    public void setDepositTypename(String depositTypename) {
        this.depositTypename = depositTypename;
    }

}