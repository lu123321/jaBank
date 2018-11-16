package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.Address;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AddressMassageDao {
    //常用地址查询
    @Select("select addressid,address,phone,addresstype,addressstate,phonestate from address where userid=#{userid}")
    Address addSelect(Integer userid);
    //常用地址删除
    @Update("update address set address=#{address},phone=#{phone},addresstype=#{addresstype},addressstate=#{addressstate},phonestate=#{phonestate} where addressid=#{addressid}")
    int delAddress(Address address);
    //常用地址修改
    int updateAddress(Address address);
    //常用地址增加
    int addAddress(Address address);
}
