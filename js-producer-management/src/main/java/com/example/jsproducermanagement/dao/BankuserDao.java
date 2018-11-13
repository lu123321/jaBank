package com.example.jsproducermanagement.dao;

import com.example.jsproducermanagement.entity.Bankuser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Bankuser)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-12 21:14:23
 */
public interface BankuserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键x
     * @return 实例对象
     */
    Bankuser queryById(Integer userid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Bankuser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bankuser 实例对象
     * @return 对象列表
     */
    List<Bankuser> queryAll(Bankuser bankuser);

    /**
     * 新增数据
     *
     * @param bankuser 实例对象
     * @return 影响行数
     */
    int insert(Bankuser bankuser);

    /**
     * 修改数据
     *
     * @param bankuser 实例对象
     * @return 影响行数
     */
    int update(Bankuser bankuser);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 影响行数
     */
    int deleteById(Integer userid);

}