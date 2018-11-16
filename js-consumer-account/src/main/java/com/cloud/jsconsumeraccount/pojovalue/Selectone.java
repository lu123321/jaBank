package com.cloud.jsconsumeraccount.pojovalue;

public class Selectone {

    private Integer UserId;
    private String timeone;
    private String timetwo;
    private Integer index;
    private Integer pageSize;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getTimeone() {
        return timeone;
    }

    public void setTimeone(String timeone) {
        this.timeone = timeone;
    }

    public String getTimetwo() {
        return timetwo;
    }

    public void setTimetwo(String timetwo) {
        this.timetwo = timetwo;
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
