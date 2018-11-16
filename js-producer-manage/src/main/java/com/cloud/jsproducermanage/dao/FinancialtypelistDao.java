package com.cloud.jsproducermanage.dao;

import com.cloud.jsproducermanage.entity.Financialtypelist;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Financialtypelist)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-10 08:53:04
 */
public interface FinancialtypelistDao {

    /**
     * 通过ID查询单条数据
     *
     * @param financialtypelistId 主键
     * @return 实例对象
     */
    Financialtypelist queryById(Integer financialtypelistId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Financialtypelist> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param financialtypelist 实例对象
     * @return 对象列表
     */
    List<Financialtypelist> queryAll(Financialtypelist financialtypelist);

    /**
     * 新增数据
     *
     * @param financialtypelist 实例对象
     * @return 影响行数
     */
    int insert(Financialtypelist financialtypelist);

    /**
     * 修改数据
     *
     * @param financialtypelist 实例对象
     * @return 影响行数
     */
    int update(Financialtypelist financialtypelist);

    /**
     * 通过主键删除数据
     *
     * @param financialtypelistId 主键
     * @return 影响行数
     */
    int deleteById(Integer financialtypelistId);

}