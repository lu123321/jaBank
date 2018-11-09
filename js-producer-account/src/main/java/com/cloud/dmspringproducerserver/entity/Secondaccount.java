package com.cloud.dmspringproducerserver.entity;

import java.io.Serializable;

/**
 * (Secondaccount)实体类
 *
 * @author makejava
 * @since 2018-11-08 22:07:20
 */
public class Secondaccount implements Serializable {
    private static final long serialVersionUID = 465673809585200946L;
    //二类账户表ID
    private Integer accountId;
    //身份证号
    private String accountIdnumber;
    //二类账户卡号
    private String accountCard;
    //开户行1:中行2:建行3:工行4:农行5:交行6:民行7:招行8:邮行9:浦发10: 中信
    private Integer accountOpenbank;
    //银行卡密码
    private Integer accountPwd;
    //账户用户ID
    private Integer accountUserid;


    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountIdnumber() {
        return accountIdnumber;
    }

    public void setAccountIdnumber(String accountIdnumber) {
        this.accountIdnumber = accountIdnumber;
    }

    public String getAccountCard() {
        return accountCard;
    }

    public void setAccountCard(String accountCard) {
        this.accountCard = accountCard;
    }

    public Integer getAccountOpenbank() {
        return accountOpenbank;
    }

    public void setAccountOpenbank(Integer accountOpenbank) {
        this.accountOpenbank = accountOpenbank;
    }

    public Integer getAccountPwd() {
        return accountPwd;
    }

    public void setAccountPwd(Integer accountPwd) {
        this.accountPwd = accountPwd;
    }

    public Integer getAccountUserid() {
        return accountUserid;
    }

    public void setAccountUserid(Integer accountUserid) {
        this.accountUserid = accountUserid;
    }

}