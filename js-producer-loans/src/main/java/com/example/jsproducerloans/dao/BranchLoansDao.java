package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.entity.BranchLoans;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (BranchLoans)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-20 11:13:38
 */
@Component
public interface BranchLoansDao {

    /**
     * 通过ID查询单条数据
     * @param branchFinancialid 主键
     * @return 实例对象
     */
    BranchLoans queryById(Integer branchFinancialid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BranchLoans> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param branchLoans 实例对象
     * @return 对象列表
     */
    List<BranchLoans> queryAll(BranchLoans branchLoans);

    /**
     * 新增数据
     *
     * @param branchLoans 实例对象
     * @return 影响行数
     */
    int insert(BranchLoans branchLoans);

    /**
     * 修改数据
     *
     * @param branchLoans 实例对象
     * @return 影响行数
     */
    int update(BranchLoans branchLoans);

    /**
     * 通过主键删除数据
     *
     * @param branchFinancialid 主键
     * @return 影响行数
     */
    int deleteById(Integer branchFinancialid);

}