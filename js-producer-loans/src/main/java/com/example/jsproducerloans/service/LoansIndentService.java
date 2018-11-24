package com.example.jsproducerloans.service;

import com.example.jsproducerloans.entity.LoansIndent;
import java.util.List;

/**
 * (LoansIndent)表服务接口
 *
 * @author makejava
 * @since 2018-11-17 17:23:49
 */
public interface LoansIndentService {

    /**
     * 通过ID查询单条数据
     *
     * @param loansIndentid 主键
     * @return 实例对象
     */
    LoansIndent queryById(Integer loansIndentid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LoansIndent> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param loansIndent 实例对象
     * @return 实例对象
     */
    String insert(LoansIndent loansIndent,String[] name,String[] value);

    /**
     * 修改数据
     *
     * @param loansIndent 实例对象
     * @return 实例对象
     */
    String update(LoansIndent loansIndent);

    /**
     * 通过主键删除数据
     *
     * @param loansIndentid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer loansIndentid);

    /**
     * 根据用户id查询信息
     * @param userid
     * @return
     */
    String getInformByUserId(String userid);

    /**
     * 根据订单id进行订单状态修改及进行一系列操作
     * @param informid
     * @return
     */
    String changeByinformid(String informid);

    /**
     * 根据贷款订单查看此订单下的所有逾期信息记录
     * @param informid
     * @return
     */
     String overduelist(String informid);

    /**
     * 根据传入逾期期数和金额进行逾期处理
     * @param planid
     * @param money
     * @return
     */
     String returnover(String planid,String money);

    /**
     * 根据订单id查看用户一次性还款需要还多少钱
     * @param informid
     * @return
     */
     String residBenjin(String informid);

    /**
     * 根据用户id进行修改订单状态
     * @param informid
     * @return
     */
     String informquchu(String informid);
}