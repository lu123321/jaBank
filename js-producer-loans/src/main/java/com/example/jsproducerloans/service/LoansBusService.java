package com.example.jsproducerloans.service;

import com.example.jsproducerloans.entity.LoansBus;
import java.util.List;

/**
 * (LoansBus)表服务接口
 *
 * @author makejava
 * @since 2018-11-20 11:01:16
 */
public interface LoansBusService {

    /**
     * 通过ID查询单条数据
     *
     * @param loansBusid 主键
     * @return 实例对象
     */
    LoansBus queryById(Integer loansBusid);

    /**
     * 获取贷款类型
     * @return
     */
    String getloanType(String typeid);
    /**
     * 新增数据
     *
     * @param loansBus 实例对象
     * @return 实例对象
     */
    LoansBus insert(LoansBus loansBus);

    /**
     * 获取所有支行名字
     * @return
     */
    String getBankInfo();
    /**
     * 修改数据
     *
     * @param loansBus 实例对象
     * @return 实例对象
     */
    LoansBus update(LoansBus loansBus);

    /**
     * 通过主键删除数据
     *
     * @param loansBusid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer loansBusid);

}