package com.example.jsproducermanagement.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Bankuser)实体类
 *
 * @author makejava
 * @since 2018-11-12 21:14:21
 */
public class Bankuser implements Serializable {
    private static final long serialVersionUID = 556702996426781884L;
    
    private Integer userid;
    //姓名
    private String name;
    //身份证号
    private String idcard;
    //省份
    private String province;
    //城市
    private String city;
    //图片路径
    private String imgurl;
    //个人信用度（默认60）
    private Integer credit;
    //个人静态密码
    private String jingpwd;
    //性别
    private Integer sex;
    //出生日期
    private Object birthday;
    //结婚状态（1，未婚。2，已婚。3，离异。4，丧偶）
    private Integer married;
    //学历(1本科，2硕士，3博士，4大专，5高中，6初中)
    private Integer education;
    //职业
    private String occupation;
    //所在行业
    private String industry;
    //技能职称
    private String skill;
    //行政级别
    private String administrative;
    //供养人口
    private Integer people;
    //工作单位
    private String work;
    //开始工作时间
    private Date worktime;
    //网上银行状态（0未开通，1开通）
    private Integer webstate;
    //网银预留信息
    private String reservedms;
    //是否快捷支付（0否，1是）
    private Integer faststate;
    //身份证到期日期
    private Object idcarddate;
    //办卡日期
    private Object bankcarddate;
    //邮箱
    private String eMail;
    //所交税额
    private Double tallage;
    //个人积分
    private Integer integral;
    
    private String duoyu3;
    
    private String duoyu4;


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getJingpwd() {
        return jingpwd;
    }

    public void setJingpwd(String jingpwd) {
        this.jingpwd = jingpwd;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public Integer getMarried() {
        return married;
    }

    public void setMarried(Integer married) {
        this.married = married;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getAdministrative() {
        return administrative;
    }

    public void setAdministrative(String administrative) {
        this.administrative = administrative;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Date getWorktime() {
        return worktime;
    }

    public void setWorktime(Date worktime) {
        this.worktime = worktime;
    }

    public Integer getWebstate() {
        return webstate;
    }

    public void setWebstate(Integer webstate) {
        this.webstate = webstate;
    }

    public String getReservedms() {
        return reservedms;
    }

    public void setReservedms(String reservedms) {
        this.reservedms = reservedms;
    }

    public Integer getFaststate() {
        return faststate;
    }

    public void setFaststate(Integer faststate) {
        this.faststate = faststate;
    }

    public Object getIdcarddate() {
        return idcarddate;
    }

    public void setIdcarddate(Object idcarddate) {
        this.idcarddate = idcarddate;
    }

    public Object getBankcarddate() {
        return bankcarddate;
    }

    public void setBankcarddate(Object bankcarddate) {
        this.bankcarddate = bankcarddate;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public Double getTallage() {
        return tallage;
    }

    public void setTallage(Double tallage) {
        this.tallage = tallage;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getDuoyu3() {
        return duoyu3;
    }

    public void setDuoyu3(String duoyu3) {
        this.duoyu3 = duoyu3;
    }

    public String getDuoyu4() {
        return duoyu4;
    }

    public void setDuoyu4(String duoyu4) {
        this.duoyu4 = duoyu4;
    }

}