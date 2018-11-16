package com.cloud.jsconsumeraccount.pojo;

import java.io.Serializable;

/**
 * (Appointment)实体类
 *
 * @author makejava
 * @since 2018-11-10 08:49:48
 */
public class AppointmentServicepojo implements Serializable {
    private static final long serialVersionUID = -42491193991488916L;
    //预约ID
    private Integer appointmentId;
    //预约编号
    private String appointmentNumber;

    //预约人ID
    private Integer appointmentUserid;
    //预约人姓名
//    private String getAppointmentName;

    //预约业务种类1:人名币大额现金取款 2:外币现金取款
    private String appointmentBusinesstype;
    //币种  关联币种表
//    private String appointmentCurrency;
    //预约取款金额
//    private Integer appointmentPrice;
    //预约办理网点  关联网点表
    private String appointmentBranch;
    //预约办理日期(年月日)
    private String appointmentData;
    //时间段(时:分) 如 00：00 - 11：11
    private String appointmentTime;
    //手机号
//    private String appointmentPhone;
    //提交预约日期(年月日)
    private String appointmentCurrentdata;
    //预约办理渠道    1: 个人网银
    private String appointmentChannel;
    //预约执行结果1: 待银行审批 2:已撤销 3:预约失败
    private String appointmentResult;



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

    public String getAppointmentBusinesstype() {
        return appointmentBusinesstype;
    }

    public void setAppointmentBusinesstype(String appointmentBusinesstype) {
        this.appointmentBusinesstype = appointmentBusinesstype;
    }

    public String getAppointmentBranch() {
        return appointmentBranch;
    }

    public void setAppointmentBranch(String appointmentBranch) {
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

    public String getAppointmentCurrentdata() {
        return appointmentCurrentdata;
    }

    public void setAppointmentCurrentdata(String appointmentCurrentdata) {
        this.appointmentCurrentdata = appointmentCurrentdata;
    }

    public String getAppointmentChannel() {
        return appointmentChannel;
    }

    public void setAppointmentChannel(String appointmentChannel) {
        this.appointmentChannel = appointmentChannel;
    }

    public String getAppointmentResult() {
        return appointmentResult;
    }

    public void setAppointmentResult(String appointmentResult) {
        this.appointmentResult = appointmentResult;
    }


}