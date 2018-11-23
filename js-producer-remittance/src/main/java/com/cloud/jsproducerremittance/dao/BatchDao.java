package com.cloud.jsproducerremittance.dao;

import com.cloud.jsproducerremittance.entity.Batch;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Batch)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-10 08:51:40
 */
public interface BatchDao {

    /**
     * 通过ID查询单条数据
     *
     * @param batchId 主键
     * @return 实例对象
     */
    Batch queryById(Integer batchId);



    /**
     * 通过实体作为筛选条件查询
     *
     * @param
     * @return 对象列表
     */
    List<Batch> queryAll(@Param("batchNumber") String batchNumber,@Param("batchPaynumber") String batchPaynumber,@Param("oneTime") String oneTime,@Param("twoTime") String twoTime);

    /**
     * 新增数据
     *
     * @param batch 实例对象
     * @return 影响行数
     */
    int insert(Batch batch);

    /**
     * 修改数据
     *
     * @param batch 实例对象
     * @return 影响行数
     */
    int update(Batch batch);

    /**
     * 通过主键删除数据
     *
     * @param batchId 主键
     * @return 影响行数
     */
    int deleteById(Integer batchId);

}