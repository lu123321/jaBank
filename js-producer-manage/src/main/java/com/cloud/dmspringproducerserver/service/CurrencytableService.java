package com.cloud.dmspringproducerserver.service;

import com.cloud.dmspringproducerserver.entity.Currencytable;
import java.util.List;

/**
 * (Currencytable)表服务接口
 *
 * @author makejava
 * @since 2018-11-08 22:11:34
 */
public interface CurrencytableService {

    /**
     * 通过ID查询单条数据
     *
     * @param currencytableId 主键
     * @return 实例对象
     */
    Currencytable queryById(Integer currencytableId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Currencytable> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param currencytable 实例对象
     * @return 实例对象
     */
    Currencytable insert(Currencytable currencytable);

    /**
     * 修改数据
     *
     * @param currencytable 实例对象
     * @return 实例对象
     */
    Currencytable update(Currencytable currencytable);

    /**
     * 通过主键删除数据
     *
     * @param currencytableId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer currencytableId);

}