package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.entity.LoansType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (LoansType)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-20 11:01:16
 */
@Component
public interface LoansTypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param loansTypeid 主键
     * @return 实例对象
     */
    LoansType queryById(Integer loansTypeid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LoansType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param loansType 实例对象
     * @return 对象列表
     */
    List<LoansType> queryAll(LoansType loansType);

    /**
     * 新增数据
     *
     * @param loansType 实例对象
     * @return 影响行数
     */
    int insert(LoansType loansType);

    /**
     * 修改数据
     *
     * @param loansType 实例对象
     * @return 影响行数
     */
    int update(LoansType loansType);

    /**
     * 通过主键删除数据
     *
     * @param loansTypeid 主键
     * @return 影响行数
     */
    int deleteById(Integer loansTypeid);

    /**
     * 获得所有贷款业务大类型
     * @return
     */
    List<LoansType> getAllType();
}