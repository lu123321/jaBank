package com.example.jsdengluprovider.pojo;

//地址
public class Address {
    private Integer addressid;//地址ID
    private String address;//具体地址
    private String phone;//固定电话
    private String addresstype;//地址类型（1家里，2公司）
    private Integer addressstate;//是否是常用地址
    private Integer phonestate;//是否是常用电话

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddresstype() {
        return addresstype;
    }

    public void setAddresstype(String addresstype) {
        this.addresstype = addresstype;
    }

    public Integer getAddressstate() {
        return addressstate;
    }

    public void setAddressstate(Integer addressstate) {
        this.addressstate = addressstate;
    }

    public Integer getPhonestate() {
        return phonestate;
    }

    public void setPhonestate(Integer phonestate) {
        this.phonestate = phonestate;
    }
}
