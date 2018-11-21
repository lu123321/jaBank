package com.cloud.jsproducerremittance.service;

import com.cloud.jsproducerremittance.entity.Batch;
import java.util.List;

/**
 * (Batch)表服务接口
 *
 * @author makejava
 * @since 2018-11-10 08:51:40
 */
public interface BatchService {

    /**
     * 通过ID查询单条数据
     *
     * @param batchId 主键
     * @return 实例对象
     */
    Batch queryById(Integer batchId);

    /**
     * 验证输入是银行卡号
     * @param number
     * @return
     */
    String verifycard(String number);

    /**
     * 新增数据
     *
     * @param batch 实例对象
     * @return 实例对象
     */
    String insert(String batch);

    /**
     * 修改数据
     *
     * @param batch 实例对象
     * @return 实例对象
     */
    Batch update(Batch batch);

    /**
     * 通过主键删除数据
     *
     * @param batchId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer batchId);

}