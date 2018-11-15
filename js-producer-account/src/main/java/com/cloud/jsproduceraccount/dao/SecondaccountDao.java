package com.cloud.jsproduceraccount.dao;

import com.cloud.jsproduceraccount.entity.Secondaccount;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Secondaccount)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-10 08:50:53
 */
public interface SecondaccountDao {

    /**
     * 通过ID查询单条数据
     *
     * @param accountUserid 主键
     * @return 实例对象
     */
    Secondaccount queryById(Integer accountUserid);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param secondaccount 实例对象
     * @return 对象列表
     */
    List<Secondaccount> queryAll(Secondaccount secondaccount);

    /**
     * 新增数据
     * +++++++++++++++++++++++++++
     * @param secondaccount 实例对象
     * @return 影响行数
     */
    int insert(Secondaccount secondaccount);

    /**
     * 根据卡号查询出价格
     * @param accountCard
     * @return
     */
    Secondaccount selprice(String accountCard);
    /**
     * 修改数据
     *
     * @param
     * @return 影响行数
     */
    int update(@Param("price") Double price,@Param("accountCard") String accountCard);

    /**
     * 通过主键删除数据
     *
     * @param accountId 主键
     * @return 影响行数
     */
    int deleteById(Integer accountId);

}