package com.cloud.jsproducerremittance.service;

import com.cloud.jsproducerremittance.entity.Makeremittance;

import java.util.List;

/**
 * (Makeremittance)表服务接口
 *
 * @author makejava
 * @since 2018-11-22 20:51:09
 */
public interface MakeremittanceService {

    /**
     * 通过时间 预约编号 用户ID 查询预约信息表
     *
     * @param
     * @return 实例对象
     */
    String queryAll(String selmaker);

    /**
     * 新增数据
     *
     * @param ma 实例对象
     * @return 实例对象
     */
    String insert(Makeremittance ma);

    /**
     * 根据预约编号 和用户ID
     * @param selonemaker
     * @return
     */
    String selonemaker(String selonemaker);

   /**
     * 修改数据
     *
     * @param updatamaker userid 实例对象
     * @return 实例对象*/

    String update(String updatamaker);

    /**
     * 通过主键删除数据
     *
     * @param makeremittanceId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer makeremittanceId);

}