package com.cloud.dmspringproducerserver.service;

import com.cloud.dmspringproducerserver.entity.Secondaccount;
import java.util.List;

/**
 * (Secondaccount)表服务接口
 *
 * @author makejava
 * @since 2018-11-08 22:07:20
 */
public interface SecondaccountService {

    /**
     * 通过ID查询单条数据
     *
     * @param accountId 主键
     * @return 实例对象
     */
    Secondaccount queryById(Integer accountId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Secondaccount> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param secondaccount 实例对象
     * @return 实例对象
     */
    Secondaccount insert(Secondaccount secondaccount);

    /**
     * 修改数据
     *
     * @param secondaccount 实例对象
     * @return 实例对象
     */
    Secondaccount update(Secondaccount secondaccount);

    /**
     * 通过主键删除数据
     *
     * @param accountId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer accountId);

}