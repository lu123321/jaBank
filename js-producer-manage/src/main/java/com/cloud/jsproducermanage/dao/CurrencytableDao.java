package com.cloud.jsproducermanage.dao;

import com.cloud.jsproducermanage.entity.Currencytable;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Currencytable)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-10 08:53:36
 */
public interface CurrencytableDao {

    /**
     * 通过ID查询单条数据
     *
     * @param currencytableId 主键
     * @return 实例对象
     */
    Currencytable queryById(Integer currencytableId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Currencytable> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param currencytable 实例对象
     * @return 对象列表
     */
    List<Currencytable> queryAll(Currencytable currencytable);

    /**
     * 新增数据
     *
     * @param currencytable 实例对象
     * @return 影响行数
     */
    int insert(Currencytable currencytable);

    /**
     * 修改数据
     *
     * @param currencytable 实例对象
     * @return 影响行数
     */
    int update(Currencytable currencytable);

    /**
     * 通过主键删除数据
     *
     * @param currencytableId 主键
     * @return 影响行数
     */
    int deleteById(Integer currencytableId);

}