package com.cloud.jsproduceraccount.dao;

import com.cloud.jsproduceraccount.entity.Detailenquiry;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Detailenquiry)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-10 08:50:36
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
     * 通过实体作为筛选条件查询
     *
     * @param detailenquiryNumber
     * @return 对象列表
     */
    List<Detailenquiry> queryAll(String detailenquiryNumber,String detailenquiryDataS,String detailenquiryFundflow);












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