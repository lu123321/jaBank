package com.cloud.jsproduceraccount.service.pojovalue;

import java.io.Serializable;

public class Detailenvalue implements Serializable {

    private String Number;
    private String onetime;
    private String twotime;
    private Integer Fundflow;
    private Integer index; //分页
    private Integer pageSize;//分页

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getOnetime() {
        return onetime;
    }

    public void setOnetime(String onetime) {
        this.onetime = onetime;
    }

    public String getTwotime() {
        return twotime;
    }

    public void setTwotime(String twotime) {
        this.twotime = twotime;
    }

    public Integer getFundflow() {
        return Fundflow;
    }

    public void setFundflow(Integer fundflow) {
        Fundflow = fundflow;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
