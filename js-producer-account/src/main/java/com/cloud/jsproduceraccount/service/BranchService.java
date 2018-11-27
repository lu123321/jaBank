package com.cloud.jsproduceraccount.service;

import com.cloud.jsproduceraccount.entity.Branch;

import java.text.ParseException;
import java.util.List;

/**
 * (Branch)表服务接口
 *
 * @author makejava
 * @since 2018-11-12 10:41:38
 */
public interface BranchService {

    /**
     * 通过ID查询单条数据
     *
     * @param branchId 主键
     * @return 实例对象
     */
    String queryById(Integer branchId);

    /**
     * 根据ID查询网点信息
     * @return
     */
    String queryByallid(Integer branchId);

    /**
     * 根据业务类型查询可办理银行
     * @param //branchBusinessone 预约人民币大额提现
     * @param //branchBusinesstwo 外币现金取款
     */
    String query(Integer branchBusinessone);
    /**
     *
     * 根据星期几和网点ID查询网点受理业务时间段
     */
    String queryIdAndTime(Integer branchId,String time) throws ParseException;

    /**
     * 新增数据
     *
     * @param branch 实例对象
     * @return 实例对象
     */
    Branch insert(Branch branch);

    /**
     * 通过主键删除数据
     *
     * @param branchId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer branchId);

}