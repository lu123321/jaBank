package com.cloud.dmspringproducerserver.dao;

import com.cloud.dmspringproducerserver.entity.Detailenquiry;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Detailenquiry)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-08 22:06:09
 */
public interface DetailenquiryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param detailenquiryId 主键
     * @return 实例对象
     */
    Detailenquiry queryById(Integer detailenquiryId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Detailenquiry> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param detailenquiry 实例对象
     * @return 对象列表
     */
    List<Detailenquiry> queryAll(Detailenquiry detailenquiry);

    /**
     * 新增数据
     *
     * @param detailenquiry 实例对象
     * @return 影响行数
     */
    int insert(Detailenquiry detailenquiry);

    /**
     * 修改数据
     *
     * @param detailenquiry 实例对象
     * @return 影响行数
     */
    int update(Detailenquiry detailenquiry);

    /**
     * 通过主键删除数据
     *
     * @param detailenquiryId 主键
     * @return 影响行数
     */
    int deleteById(Integer detailenquiryId);

}