package com.example.jsdengluprovider.pojo;

import com.example.jsdengluprovider.util.date.DateUtil;

import java.util.Date;

//银行卡信息
public class BankCard {
    private Integer cardid;//银行卡ID
    private Integer cardtype;//银行卡类型（1是银行卡，2是信用卡）
    private String userpwd;//银行卡密码
    private String cardnum;//银行卡号
    private String username;//用户名
    private String phone;//银行卡预留手机号
    private Integer userid; //用户ID
    private String webpwd;//网银登录密码
    private Integer state;//银行卡状态（0正常，1挂失，2临时挂失，3未激活）
    private Double balance;//卡内余额
    private String carddate;//办卡日期
    private Integer webcardstate;//该卡是否是网银
    private String branchname;//办卡网点名称
    private Double  availablebalance;//可用余额

    public Double getAvailablebalance() {
        return availablebalance;
    }

    public void setAvailablebalance(Double availablebalance) {
        this.availablebalance = availablebalance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebpwd() {
        return webpwd;
    }

    public void setWebpwd(String webpwd) {
        this.webpwd = webpwd;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public Integer getWebcardstate() {
        return webcardstate;
    }

    public void setWebcardstate(Integer webcardstate) {
        this.webcardstate = webcardstate;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public Date getCarddate() {
        return DateUtil.SchangeD(carddate);
    }

    public void setCarddate(String carddate) {
        this.carddate = carddate;
    }

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public Integer getCardtype() {
        return cardtype;
    }

    public void setCardtype(Integer cardtype) {
        this.cardtype = cardtype;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
