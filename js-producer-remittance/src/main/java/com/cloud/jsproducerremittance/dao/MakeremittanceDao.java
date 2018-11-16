package com.cloud.jsproducerremittance.dao;

import com.cloud.jsproducerremittance.entity.Makeremittance;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Makeremittance)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-10 08:51:56
 */
public interface MakeremittanceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param makeremittanceId 主键
     * @return 实例对象
     */
    Makeremittance queryById(Integer makeremittanceId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Makeremittance> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param makeremittance 实例对象
     * @return 对象列表
     */
    List<Makeremittance> queryAll(Makeremittance makeremittance);

    /**
     * 新增数据
     *
     * @param makeremittance 实例对象
     * @return 影响行数
     */
    int insert(Makeremittance makeremittance);

    /**
     * 修改数据
     *
     * @param makeremittance 实例对象
     * @return 影响行数
     */
    int update(Makeremittance makeremittance);

    /**
     * 通过主键删除数据
     *
     * @param makeremittanceId 主键
     * @return 影响行数
     */
    int deleteById(Integer makeremittanceId);

}