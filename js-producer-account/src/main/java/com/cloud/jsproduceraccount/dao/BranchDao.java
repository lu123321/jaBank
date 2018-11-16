package com.cloud.jsproduceraccount.dao;

import com.cloud.jsproduceraccount.entity.Branch;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Branch)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-12 10:41:38
 */
public interface BranchDao {

    /**
     * 通过ID查询单条数据
     *
     * @param branchId 主键
     * @return 实例对象
     */
    Branch queryById(@Param("id") Integer branchId);

    /**
     * 根据ID查询网点信息
     * @param branchId
     * @return
     */
    Branch queryByallid(@Param("id") Integer branchId);



    /**
     * 根据网址ID查询网点名称
     * @param branchId
     * @return
     */
    Branch querybyid(@Param("id") Integer branchId);
    /**
     *
     * 根据星期几和网点ID查询网点受理业务时间段
     */
    Branch queryByIdAndTime(@Param("id") Integer branchId,@Param("one") Integer one,@Param("two") Integer two);
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
     * 根据业务类型查询可办理银行数量
     * @param //branchBusinessone 预约人民币大额提现
     * @param //branchBusinesstwo 外币现金取款
     */
    List<Branch> query(@Param("one") Integer branchBusinessone,@Param("two") Integer branchBusinesstwo);
    /**
     * 根据业务类型查询可办理银行名称
     *
     */

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

}