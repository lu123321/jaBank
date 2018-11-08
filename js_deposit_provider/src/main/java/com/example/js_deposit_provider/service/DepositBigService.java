package com.example.js_deposit_provider.service;

import com.example.js_deposit_provider.entity.DepositBig;
import java.util.List;

/**
 * (DepositBig)表服务接口
 *
 * @author makejava
 * @since 2018-11-08 10:32:28
 */
public interface DepositBigService {

    /**
     * 通过ID查询单条数据
     *
     * @param depositBigid 主键
     * @return 实例对象
     */
    DepositBig queryById(Integer depositBigid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DepositBig> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param depositBig 实例对象
     * @return 实例对象
     */
    DepositBig insert(DepositBig depositBig);

    /**
     * 修改数据
     *
     * @param depositBig 实例对象
     * @return 实例对象
     */
    DepositBig update(DepositBig depositBig);

    /**
     * 通过主键删除数据
     *
     * @param depositBigid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer depositBigid);

}