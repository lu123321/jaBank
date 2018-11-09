package com.cloud.dmspringproducerserver.service;

import com.cloud.dmspringproducerserver.entity.Remittancetransaction;
import java.util.List;

/**
 * (Remittancetransaction)表服务接口
 *
 * @author makejava
 * @since 2018-11-08 22:08:11
 */
public interface RemittancetransactionService {

    /**
     * 通过ID查询单条数据
     *
     * @param remittancetransactionId 主键
     * @return 实例对象
     */
    Remittancetransaction queryById(Integer remittancetransactionId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Remittancetransaction> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param remittancetransaction 实例对象
     * @return 实例对象
     */
    Remittancetransaction insert(Remittancetransaction remittancetransaction);

    /**
     * 修改数据
     *
     * @param remittancetransaction 实例对象
     * @return 实例对象
     */
    Remittancetransaction update(Remittancetransaction remittancetransaction);

    /**
     * 通过主键删除数据
     *
     * @param remittancetransactionId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer remittancetransactionId);

}