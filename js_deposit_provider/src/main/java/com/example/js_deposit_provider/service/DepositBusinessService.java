package com.example.js_deposit_provider.service;

import com.example.js_deposit_provider.entity.DepositBusiness;
import java.util.List;

/**
 * (DepositBusiness)表服务接口
 *
 * @author makejava
 * @since 2018-11-10 09:18:59
 */
public interface DepositBusinessService {

    /**
     * 通过ID查询单条数据
     *
     * @param depositBusinessid 主键
     * @return 实例对象
     */
    DepositBusiness queryById(Integer depositBusinessid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DepositBusiness> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param depositBusiness 实例对象
     * @return 实例对象
     */
    DepositBusiness insert(DepositBusiness depositBusiness);

    /**
     * 修改数据
     *
     * @param depositBusiness 实例对象
     * @return 实例对象
     */
    DepositBusiness update(DepositBusiness depositBusiness);

    /**
     * 通过主键删除数据
     *
     * @param depositBusinessid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer depositBusinessid);

    /**
     * 根据类型id进行查询
     * @param typeid
     * @return
     */
    String getByType(String typeid);
}