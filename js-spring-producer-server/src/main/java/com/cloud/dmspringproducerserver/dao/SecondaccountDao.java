package com.cloud.dmspringproducerserver.dao;

import com.cloud.dmspringproducerserver.entity.Secondaccount;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Secondaccount)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-08 22:07:20
 */
public interface SecondaccountDao {

    /**
     * 通过ID查询单条数据
     *
     * @param accountId 主键
     * @return 实例对象
     */
    Secondaccount queryById(Integer accountId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Secondaccount> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param secondaccount 实例对象
     * @return 对象列表
     */
    List<Secondaccount> queryAll(Secondaccount secondaccount);

    /**
     * 新增数据
     *
     * @param secondaccount 实例对象
     * @return 影响行数
     */
    int insert(Secondaccount secondaccount);

    /**
     * 修改数据
     *
     * @param secondaccount 实例对象
     * @return 影响行数
     */
    int update(Secondaccount secondaccount);

    /**
     * 通过主键删除数据
     *
     * @param accountId 主键
     * @return 影响行数
     */
    int deleteById(Integer accountId);

}