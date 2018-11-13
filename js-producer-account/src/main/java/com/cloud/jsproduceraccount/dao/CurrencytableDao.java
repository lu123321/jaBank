package com.cloud.jsproduceraccount.dao;

import com.cloud.jsproduceraccount.entity.Currencytable;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Currencytable)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-12 22:18:07
 */
public interface CurrencytableDao {

    /**
     * 通过ID查询单条数据
     *  根据ID查询币种表
     * @param currencytableId 主键
     * @return 实例对象
     */
    Currencytable queryById(Integer currencytableId);

}