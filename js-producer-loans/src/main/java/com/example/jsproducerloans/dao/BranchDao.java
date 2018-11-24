package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.entity.Branch;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Branch)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-20 11:13:38
 */
@Component
public interface BranchDao {

    /**
     * 通过ID查询单条数据
     *
     * @param branchId 主键
     * @return 实例对象
     */
    Branch queryById(Integer branchId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Branch> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param branch 实例对象
     * @return 对象列表
     */
    List<Branch> queryAll(Branch branch);

    /**
     * 新增数据
     *
     * @param branch 实例对象
     * @return 影响行数
     */
    int insert(Branch branch);

    /**
     * 修改数据
     *
     * @param branch 实例对象
     * @return 影响行数
     */
    int update(Branch branch);

    /**
     * 通过主键删除数据
     *
     * @param branchId 主键
     * @return 影响行数
     */
    int deleteById(Integer branchId);

    /**
     * 获取全部支行信息
     * @return
     */
    List<Branch> getAll();
}