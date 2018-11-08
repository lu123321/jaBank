package com.example.jsdengluprovider.pojo;

//额度限制
public class Limit {
    private Integer disanfangid;//第三方ID
    private String sanname;//第三方名称
    private Double onelimit;//第一笔限额
    private Double daylimit;//日累计限额
    private Double moonlimit;//月额度限额

    public Integer getDisanfangid() {
        return disanfangid;
    }

    public void setDisanfangid(Integer disanfangid) {
        this.disanfangid = disanfangid;
    }

    public String getSanname() {
        return sanname;
    }

    public void setSanname(String sanname) {
        this.sanname = sanname;
    }

    public Double getOnelimit() {
        return onelimit;
    }

    public void setOnelimit(Double onelimit) {
        this.onelimit = onelimit;
    }

    public Double getDaylimit() {
        return daylimit;
    }

    public void setDaylimit(Double daylimit) {
        this.daylimit = daylimit;
    }

    public Double getMoonlimit() {
        return moonlimit;
    }

    public void setMoonlimit(Double moonlimit) {
        this.moonlimit = moonlimit;
    }
}
