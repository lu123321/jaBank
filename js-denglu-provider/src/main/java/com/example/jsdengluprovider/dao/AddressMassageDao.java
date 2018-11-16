package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.Address;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface AddressMassageDao {
    //常用地址查询
    @Select("select addressid,address,phone,addresstype,addressstate,phonestate from address where userid=#{userid}")
    Address addSelect(@Param("userid") Integer userid);
    //常用地址删除
    @Delete("delete from address where addressid=#{addressid}")
    int delAddress(Address address);
    //常用地址修改
    @Update("update address set address=#{address},phone=#{phone},addresstype=#{addresstype},addressstate=#{addressstate},phonestate=#{phonestate} where addressid=#{addressid}")
    int updateAddress(Address address);
    //常用地址增加
    @Insert("insert into address(addressid,address,phone,userid,addresstype,addressstate,phonestate) values (0,#{address},#{phone},#{userid},#{addresstype},#{addressstate},#{phonestate})")
    int addAddress(Address address);
}
