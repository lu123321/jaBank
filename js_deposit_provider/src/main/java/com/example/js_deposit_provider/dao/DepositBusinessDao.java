package com.example.js_deposit_provider.dao;

import com.example.js_deposit_provider.entity.DepositBusiness;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (DepositBusiness)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-10 09:18:59
 */
@Component
public interface DepositBusinessDao {

    /**
     * 通过ID查询单条数据
     *
     * @param depositBusinessid 主键
     * @return 实例对象
     */
    DepositBusiness queryById(Integer depositBusinessid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DepositBusiness> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param depositBusiness 实例对象
     * @return 对象列表
     */
    List<DepositBusiness> queryAll(DepositBusiness depositBusiness);

    /**
     * 新增数据
     *
     * @param depositBusiness 实例对象
     * @return 影响行数
     */
    int insert(DepositBusiness depositBusiness);

    /**
     * 修改数据
     *
     * @param depositBusiness 实例对象
     * @return 影响行数
     */
    int update(DepositBusiness depositBusiness);

    /**
     * 通过主键删除数据
     *
     * @param depositBusinessid 主键
     * @return 影响行数
     */
    int deleteById(Integer depositBusinessid);

    /**
     * 查询全部数据
     * @return
     */
    List<DepositBusiness> getAll();

    /**
     * 通过业务id查看业务时长
     * @param bussId
     * @return
     */
    int getlong(int bussId);
}