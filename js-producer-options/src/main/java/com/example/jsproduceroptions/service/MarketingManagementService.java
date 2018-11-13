package com.example.jsproduceroptions.service;

import com.example.jsproduceroptions.entity.MarketingManagement;

import java.util.List;

/**
 * (MarketingManagement)表服务接口
 *
 * @author makejava
 * @since 2018-11-08 16:01:18
 */
public interface MarketingManagementService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId,number
     *
     * @return 实例对象
     */
    String queryById(Integer userId,Integer number);

    /**
     * 查询多条数据
     *
     * @param userId 用户id查询
     * @return 对象列表
     */
    List<MarketingManagement> queryAll(Integer userId);

    /**
     * 新增数据
     *
     * @param userId,name,marketing,phone,state 实例对象
     * @return 实例对象
     */
    String insert(Integer userId,String name,String marketing,String phone,Integer state);

    /**
     * 修改数据
     *
     * @param marketingManagement 实例对象
     * @return 实例对象
     */
    String update(MarketingManagement marketingManagement);

    /**
     * 通过主键删除数据
     *
     * @param userId 和 number 删除
     * @return 是否成功
     */
    String deleteById(Integer userId,Integer number);

}