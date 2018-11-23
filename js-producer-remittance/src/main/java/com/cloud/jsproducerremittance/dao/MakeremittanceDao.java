package com.cloud.jsproducerremittance.dao;

import com.cloud.jsproducerremittance.entity.Makeremittance;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Makeremittance)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-22 20:51:09
 */
public interface MakeremittanceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param Serialnumber 根据预约编号 和用户ID
     * @return 实例对象
     */
    Makeremittance queryByIdd(@Param("Serialnumber") String Serialnumber,@Param("userid") Integer userid);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param
     * @return 对象列表
     */
    List<Makeremittance> queryAll(@Param("onetime") String onetime,@Param("twotime") String twotime,@Param("userid") Integer userid);

    /**
     * 新增数据
     *  添加预约汇款信息
     * @param makeremittance 实例对象
     * @return 影响行数
     */
    int insert(Makeremittance makeremittance);

    /**
     * 修改数据 修改预约状态为取消  撤销操作
     *
     * @param Serialnumber 实例对象
     * @return 影响行数
     */
    int update(@Param("Serialnumber") String Serialnumber,@Param("userid") Integer userid);

    /**
     * 通过主键删除数据
     *
     * @param makeremittanceId 主键
     * @return 影响行数
     */
    int deleteById(Integer makeremittanceId);

}