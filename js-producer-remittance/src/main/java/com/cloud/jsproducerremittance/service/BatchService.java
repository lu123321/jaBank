package com.cloud.jsproducerremittance.service;

import com.cloud.jsproducerremittance.entity.Batch;
import com.cloud.jsproducerremittance.pojovalue.Batchvalue;

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
    String queryById(Integer batchId);

    /**
     * 验证输入是银行卡号
     * @param number
     * @return
     */
    String verifycard(String number);

    /**
     * 根据卡号和时间段查询批量明细
     * @param ba
     * @return
     */
    String queryAll(Batchvalue ba);
    /**
     * 新增数据
     *
     * @param batch 实例对象
     * @return 实例对象
     */
    String insert(String batch);



    /**
     * 通过主键删除数据
     *
     * @param batchId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer batchId);

}