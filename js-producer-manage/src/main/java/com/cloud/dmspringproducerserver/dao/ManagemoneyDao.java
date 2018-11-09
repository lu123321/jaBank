package com.cloud.dmspringproducerserver.dao;

import com.cloud.dmspringproducerserver.entity.Managemoney;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Managemoney)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-08 22:10:41
 */
public interface ManagemoneyDao {

    /**
     * 通过ID查询单条数据
     *
     * @param managemoneyId 主键
     * @return 实例对象
     */
    Managemoney queryById(Integer managemoneyId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Managemoney> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param managemoney 实例对象
     * @return 对象列表
     */
    List<Managemoney> queryAll(Managemoney managemoney);

    /**
     * 新增数据
     *
     * @param managemoney 实例对象
     * @return 影响行数
     */
    int insert(Managemoney managemoney);

    /**
     * 修改数据
     *
     * @param managemoney 实例对象
     * @return 影响行数
     */
    int update(Managemoney managemoney);

    /**
     * 通过主键删除数据
     *
     * @param managemoneyId 主键
     * @return 影响行数
     */
    int deleteById(Integer managemoneyId);

}