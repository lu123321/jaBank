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
     * 通过ID查询单条数据
     *
     * @param makeremittanceId 主键
     * @return 实例对象
     */
    Makeremittance queryById(Integer makeremittanceId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Makeremittance> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param ma 实例对象
     * @return 实例对象
     */
    String insert(Makeremittance ma);

    /**
     * 修改数据
     *
     * @param makeremittance 实例对象
     * @return 实例对象
     */
    Makeremittance update(Makeremittance makeremittance);

    /**
     * 通过主键删除数据
     *
     * @param makeremittanceId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer makeremittanceId);

}