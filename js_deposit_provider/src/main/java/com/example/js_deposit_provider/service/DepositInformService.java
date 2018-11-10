package com.example.js_deposit_provider.service;

import com.example.js_deposit_provider.entity.DepositInform;
import java.util.List;

/**
 * (DepositInform)表服务接口
 *
 * @author makejava
 * @since 2018-11-08 10:32:29
 */
public interface DepositInformService {

    /**
     * 通过ID查询单条数据
     *
     * @param depositInformid 主键
     * @return 实例对象
     */
    DepositInform queryById(Integer depositInformid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DepositInform> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param depositInform 实例对象
     * @return 实例对象
     */
    DepositInform insert(DepositInform depositInform);

    /**
     * 修改数据
     *
     * @param depositInform 实例对象
     * @return 实例对象
     */
    DepositInform update(DepositInform depositInform);

    /**
     * 通过主键删除数据
     *
     * @param depositInformid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer depositInformid);

}