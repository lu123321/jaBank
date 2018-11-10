package com.example.js_deposit_provider.dao;

import com.example.js_deposit_provider.entity.DepositInform;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (DepositInform)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-08 10:32:29
 */
@Component
public interface DepositInformDao {

    /**
     * 通过ID查询单条数据
     *
     * @param depositInformid 主键
     * @return 实例对象
     */
    DepositInform queryById(Integer depositInformid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DepositInform> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param depositInform 实例对象
     * @return 对象列表
     */
    List<DepositInform> queryAll(DepositInform depositInform);

    /**
     * 新增数据
     *
     * @param depositInform 实例对象
     * @return 影响行数
     */
    int insert(DepositInform depositInform);

    /**
     * 修改数据
     *
     * @param depositInform 实例对象
     * @return 影响行数
     */
    int update(DepositInform depositInform);

    /**
     * 通过主键删除数据
     *
     * @param depositInformid 主键
     * @return 影响行数
     */
    int deleteById(Integer depositInformid);

}