package com.example.js_deposit_provider.entity;

import java.io.Serializable;

/**
 * (DepositBusiness)实体类
 *
 * @author makejava
 * @since 2018-11-08 10:32:29
 */
public class DepositBusiness implements Serializable {
    private static final long serialVersionUID = -58163838876256771L;
    //存款业务id
    private Integer depositBusinessid;
    //存款业务名字
    private String depositBusinessname;
    //存款业务最低额度
    private String depositBusinessmoney;
    //存款业务利率
    private String depositBusinessrate;
    //存款业务类型
    private String depositBusinesstype;


    public Integer getDepositBusinessid() {
        return depositBusinessid;
    }

    public void setDepositBusinessid(Integer depositBusinessid) {
        this.depositBusinessid = depositBusinessid;
    }

    public String getDepositBusinessname() {
        return depositBusinessname;
    }

    public void setDepositBusinessname(String depositBusinessname) {
        this.depositBusinessname = depositBusinessname;
    }

    public String getDepositBusinessmoney() {
        return depositBusinessmoney;
    }

    public void setDepositBusinessmoney(String depositBusinessmoney) {
        this.depositBusinessmoney = depositBusinessmoney;
    }

    public String getDepositBusinessrate() {
        return depositBusinessrate;
    }

    public void setDepositBusinessrate(String depositBusinessrate) {
        this.depositBusinessrate = depositBusinessrate;
    }

    public String getDepositBusinesstype() {
        return depositBusinesstype;
    }

    public void setDepositBusinesstype(String depositBusinesstype) {
        this.depositBusinesstype = depositBusinesstype;
    }

}