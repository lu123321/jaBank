package com.cloud.jsproducermanage.service;

import com.cloud.jsproducermanage.entity.Financialrecords;
import java.util.List;

/**
 * (Financialrecords)表服务接口
 *
 * @author makejava
 * @since 2018-11-10 08:53:18
 */
public interface FinancialrecordsService {

    /**
     * 通过ID查询单条数据
     *
     * @param financialrecordsId 主键
     * @return 实例对象
     */
    Financialrecords queryById(Integer financialrecordsId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Financialrecords> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param financialrecords 实例对象
     * @return 实例对象
     */
    Financialrecords insert(Financialrecords financialrecords);

    /**
     * 修改数据
     *
     * @param financialrecords 实例对象
     * @return 实例对象
     */
    Financialrecords update(Financialrecords financialrecords);

    /**
     * 通过主键删除数据
     *
     * @param financialrecordsId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer financialrecordsId);

}