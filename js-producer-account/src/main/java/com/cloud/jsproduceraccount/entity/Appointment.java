package com.cloud.jsproduceraccount.entity;

import java.io.Serializable;

/**
 * (Appointment)实体类
 *
 * @author makejava
 * @since 2018-11-10 08:49:48
 */
public class Appointment implements Serializable {
    private static final long serialVersionUID = -42491193991488916L;
    //预约ID
    private Integer appointmentId;
    //预约编号
    private String appointmentNumber;
    //预约人ID
    private Integer appointmentUserid;
    //预约业务种类1:人名币大额现金取款 2:外币现金取款
    private Integer appointmentBusinesstype;
    //币种  关联币种表
    private Integer appointmentCurrency;
    //预约取款金额
    private String appointmentPrice;
    //预约办理网点  关联网点表
    private Integer appointmentBranch;
    //预约办理日期(年月日)
    private String appointmentData;
    //时间段(时:分) 如 00：00 - 11：11
    private String appointmentTime;
    //手机号
    private String appointmentPhone;
    //提交预约日期(年月日)
    private String appointmentCurrentdata;
    //预约办理渠道    1: 个人网银
    private Integer appointmentChannel;
    //预约执行结果1: 待银行审批 2:已撤销 3:预约失败 4：已完成
    private Integer appointmentResult;
    //冗余列
    private String appointmentOne;
    //冗余列
    private String appointmentTwo;


    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentNumber() {
        return appointmentNumber;
    }

    public void setAppointmentNumber(String appointmentNumber) {
        this.appointmentNumber = appointmentNumber;
    }

    public Integer getAppointmentUserid() {
        return appointmentUserid;
    }

    public void setAppointmentUserid(Integer appointmentUserid) {
        this.appointmentUserid = appointmentUserid;
    }

    public Integer getAppointmentBusinesstype() {
        return appointmentBusinesstype;
    }

    public void setAppointmentBusinesstype(Integer appointmentBusinesstype) {
        this.appointmentBusinesstype = appointmentBusinesstype;
    }

    public Integer getAppointmentCurrency() {
        return appointmentCurrency;
    }

    public void setAppointmentCurrency(Integer appointmentCurrency) {
        this.appointmentCurrency = appointmentCurrency;
    }

    public String getAppointmentPrice() {
        return appointmentPrice;
    }

    public void setAppointmentPrice(String appointmentPrice) {
        this.appointmentPrice = appointmentPrice;
    }

    public Integer getAppointmentBranch() {
        return appointmentBranch;
    }

    public void setAppointmentBranch(Integer appointmentBranch) {
        this.appointmentBranch = appointmentBranch;
    }

    public String getAppointmentData() {
        return appointmentData;
    }

    public void setAppointmentData(String appointmentData) {
        this.appointmentData = appointmentData;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentPhone() {
        return appointmentPhone;
    }

    public void setAppointmentPhone(String appointmentPhone) {
        this.appointmentPhone = appointmentPhone;
    }

    public String getAppointmentCurrentdata() {
        return appointmentCurrentdata;
    }

    public void setAppointmentCurrentdata(String appointmentCurrentdata) {
        this.appointmentCurrentdata = appointmentCurrentdata;
    }

    public Integer getAppointmentChannel() {
        return appointmentChannel;
    }

    public void setAppointmentChannel(Integer appointmentChannel) {
        this.appointmentChannel = appointmentChannel;
    }

    public Integer getAppointmentResult() {
        return appointmentResult;
    }

    public void setAppointmentResult(Integer appointmentResult) {
        this.appointmentResult = appointmentResult;
    }

    public String getAppointmentOne() {
        return appointmentOne;
    }

    public void setAppointmentOne(String appointmentOne) {
        this.appointmentOne = appointmentOne;
    }

    public String getAppointmentTwo() {
        return appointmentTwo;
    }

    public void setAppointmentTwo(String appointmentTwo) {
        this.appointmentTwo = appointmentTwo;
    }

}