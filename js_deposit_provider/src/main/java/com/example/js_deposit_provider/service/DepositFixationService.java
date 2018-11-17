package com.example.js_deposit_provider.service;

import com.example.js_deposit_provider.entity.DepositFixation;
import java.util.List;

/**
 * (DepositFixation)表服务接口
 *
 * @author makejava
 * @since 2018-11-08 10:32:29
 */
public interface DepositFixationService {

    /**
     * 通过ID查询单条数据
     *
     * @param depositFixationid 主键
     * @return 实例对象
     */
    DepositFixation queryById(Integer depositFixationid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DepositFixation> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param depositFixation 实例对象
     * @return 实例对象
     */
    String insert(DepositFixation depositFixation);

    /**
     * 修改数据
     *
     * @param depositFixation 实例对象
     * @return 实例对象
     */
    DepositFixation update(DepositFixation depositFixation);

    /**
     * 通过主键删除数据
     *
     * @param depositFixationid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer depositFixationid);

    /**
     * 通过用户id查看所有订单信息
     * @param userid
     * @return
     */
   String getAllById(String userid);

    /**
     * 根据订单号和金额进行普通取款
     * @param infromid
     * @param money
     * @return
     */
   String getmoney(String infromid,String money);
}