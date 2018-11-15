package com.cloud.jsproduceraccount.entity;

import java.io.Serializable;

/**
 * (Secondaccount)实体类
 *
 * @author makejava
 * @since 2018-11-10 08:50:53
 */
public class Secondaccount implements Serializable {
    private static final long serialVersionUID = -85025842426854326L;
    //二类账户表ID
    private Integer accountId;
    //身份证号
    private String accountIdnumber;
    //二类账户卡号
    private String accountCard;
    //二类账户金额
    private Double accountPrice; //第二个页面填写
    //我的填写的卡号
    private String accountMycard;
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

    public Double getAccountPrice() {
        return accountPrice;
    }

    public void setAccountPrice(Double accountPrice) {
        this.accountPrice = accountPrice;
    }

    public String getAccountMycard() {
        return accountMycard;
    }

    public void setAccountMycard(String accountMycard) {
        this.accountMycard = accountMycard;
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