package com.example.jsproduceroptions.dao;

import com.example.jsproduceroptions.entity.MarketingManagement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;




/**
 * (MarketingManagement)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-08 16:01:18
 */
@Component
public interface MarketingManagementDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    MarketingManagement queryById(@Param("userId")Integer userId,@Param("number") Integer number);


    /**
     * 通过用户id查询所有信息
     *
     * @param userid 实例对象
     * @return 对象列表
     */
    List<MarketingManagement> queryAll(Integer userid);

    /**
     * 新增数据
     *
     * @param marketingManagement 实例对象
     * @return 影响行数
     */
    int insert(MarketingManagement marketingManagement);

    /**
     * 修改数据
     *
     * @param marketingManagement 实例对象
     * @return 影响行数
     */
    int update(MarketingManagement marketingManagement);

    /**
     * 通过主键删除数据
     *
     * @param userId 和 number 删除
     * @return 影响行数
     */
    int deleteById(@Param("userId")Integer userId,@Param("number") Integer number);

}