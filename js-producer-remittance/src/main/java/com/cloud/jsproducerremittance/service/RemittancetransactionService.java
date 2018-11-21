package com.cloud.jsproducerremittance.service;

import com.cloud.jsproducerremittance.entity.Remittancetransaction;
import com.cloud.jsproducerremittance.pojovalue.Remittansel;
import com.cloud.jsproducerremittance.service.valuepojo.Remittanvalue;

import java.util.List;

/**
 * (Remittancetransaction)表服务接口
 *
 * @author makejava
 * @since 2018-11-10 08:51:22
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
     * 新增数据
     *
     * @param remittancetransaction 实例对象
     * @return 实例对象
     */
    String insert(Remittancetransaction remittancetransaction);

    /**
     * 汇款发送验证码  验证验证码
     * @param
     * @return
     */
    String SMSMQ(Remittanvalue remittanvalue);
    /**
     * 修改数据
     *
     * @param remittancetransaction 实例对象
     * @return 实例对象
     */
    Remittancetransaction update(Remittancetransaction remittancetransaction);

    /**
     * 查询单笔汇款明细
     * @param remittansel
     * @return
     */
    String selALL(Remittansel remittansel);

    /**
     * 通过主键删除数据
     *
     * @param remittancetransactionId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer remittancetransactionId);

}