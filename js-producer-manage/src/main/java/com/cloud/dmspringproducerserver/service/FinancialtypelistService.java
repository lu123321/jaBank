package com.cloud.dmspringproducerserver.service;

import com.cloud.dmspringproducerserver.entity.Financialtypelist;
import java.util.List;

/**
 * (Financialtypelist)表服务接口
 *
 * @author makejava
 * @since 2018-11-08 22:11:00
 */
public interface FinancialtypelistService {

    /**
     * 通过ID查询单条数据
     *
     * @param financialtypelistId 主键
     * @return 实例对象
     */
    Financialtypelist queryById(Integer financialtypelistId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Financialtypelist> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param financialtypelist 实例对象
     * @return 实例对象
     */
    Financialtypelist insert(Financialtypelist financialtypelist);

    /**
     * 修改数据
     *
     * @param financialtypelist 实例对象
     * @return 实例对象
     */
    Financialtypelist update(Financialtypelist financialtypelist);

    /**
     * 通过主键删除数据
     *
     * @param financialtypelistId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer financialtypelistId);

}