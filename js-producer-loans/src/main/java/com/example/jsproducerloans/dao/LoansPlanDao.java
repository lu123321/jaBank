package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.entity.LoansPlan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * (LoansPlan)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-22 21:32:47
 */
@Component
public interface LoansPlanDao {

    /**
     * 通过ID查询单条数据
     *
     * @param loansPlanid 主键
     * @return 实例对象
     */
    LoansPlan queryById(Integer loansPlanid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LoansPlan> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param loansPlan 实例对象
     * @return 对象列表
     */
    List<LoansPlan> queryAll(LoansPlan loansPlan);

    /**
     * 新增数据
     *
     * @param loansPlan 实例对象
     * @return 影响行数
     */
    int insert(LoansPlan loansPlan);

    /**
     * 修改数据
     *
     * @param loansPlan 实例对象
     * @return 影响行数
     */
    int update(LoansPlan loansPlan);

    /**
     * 订单完成后对所有还款信息进行修改
     * @param informid
     * @return
     */
    int updateallstate(int informid);

    /**
     * 通过主键删除数据
     *
     * @param loansPlanid 主键
     * @return 影响行数
     */
    int deleteById(Integer loansPlanid);

    /**
     * 查询需要本月还款的订单
     * @param nowMonth
     * @return
     */
    List<LoansPlan> getNeedPay(Date nowMonth);

    /**
     * 根据订单修改状态
     * @param planid
     * @return
     */
    int updatestate(int planid);

    /**
     * 根据贷款订单id查看所有逾期信息
     * @param informid
     * @return
     */
    List<LoansPlan> getUserover(int informid);

}