package com.example.jsproducercreditcard.dao;

import com.example.jsproducercreditcard.pojo.Credit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ApplyCreditDao {

    /**
     * 获取个人信息地址区域展示信用卡
     * @param provinc
     * @param city
     * @return
     */
    @Select("")
    Credit getAll(@Param("provinc") String provinc,@Param("city") String city);

}
