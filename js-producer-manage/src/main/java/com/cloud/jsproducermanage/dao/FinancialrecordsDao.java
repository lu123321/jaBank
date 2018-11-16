package com.cloud.jsproducermanage.dao;

import com.cloud.jsproducermanage.entity.Financialrecords;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Financialrecords)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-10 08:53:18
 */
public interface FinancialrecordsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param financialrecordsId 主键
     * @return 实例对象
     */
    Financialrecords queryById(Integer financialrecordsId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Financialrecords> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param financialrecords 实例对象
     * @return 对象列表
     */
    List<Financialrecords> queryAll(Financialrecords financialrecords);

    /**
     * 新增数据
     *
     * @param financialrecords 实例对象
     * @return 影响行数
     */
    int insert(Financialrecords financialrecords);

    /**
     * 修改数据
     *
     * @param financialrecords 实例对象
     * @return 影响行数
     */
    int update(Financialrecords financialrecords);

    /**
     * 通过主键删除数据
     *
     * @param financialrecordsId 主键
     * @return 影响行数
     */
    int deleteById(Integer financialrecordsId);

}