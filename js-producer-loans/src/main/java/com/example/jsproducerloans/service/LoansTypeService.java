package com.example.jsproducerloans.service;

import com.example.jsproducerloans.entity.LoansBus;
import com.example.jsproducerloans.entity.LoansType;
import java.util.List;

/**
 * (LoansType)表服务接口
 *
 * @author makejava
 * @since 2018-11-20 11:01:16
 */
public interface LoansTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param loansTypeid 主键
     * @return 实例对象
     */
    LoansType queryById(Integer loansTypeid);

    /**
     * 获取所有的类型信息
     * @return
     */
    String getAllType();
    /**
     * 新增数据
     *
     * @param loansType 实例对象
     * @return 实例对象
     */
    LoansType insert(LoansType loansType);

    /**
     * 修改数据
     *
     * @param loansType 实例对象
     * @return 实例对象
     */
    LoansType update(LoansType loansType);

    /**
     * 通过主键删除数据
     *
     * @param loansTypeid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer loansTypeid);

}