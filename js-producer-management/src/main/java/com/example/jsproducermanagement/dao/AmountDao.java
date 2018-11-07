package com.example.jsproducermanagement.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;


@Mapper
public interface AmountDao {
    /**
     * 用户登陆获得id，根据id修改数据库单笔支付额度和日支付额度最大不超过1w
     * @param dan
     * @param ri
     * @param id
     * @return  int
     */
    @Update("UPDATE ma_amount SET singlePay=${dan},trojanPay=${ri} WHERE userId=${id}")
    int update(@RequestParam("dan") Double dan,@RequestParam("ri") Double ri,Integer id);
}
