package com.example.js_deposit_provider.dao;

import com.example.js_deposit_provider.entity.DepositBig;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DepositBig)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-16 19:58:52
 */
public interface DepositBigDao {

    /**
     * 通过ID查询单条数据
     *
     * @param depositBigid 主键
     * @return 实例对象
     */
    DepositBig queryById(Integer depositBigid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DepositBig> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param depositBig 实例对象
     * @return 对象列表
     */
    List<DepositBig> queryAll(DepositBig depositBig);

    /**
     * 新增数据
     *
     * @param depositBig 实例对象
     * @return 影响行数
     */
    int insert(DepositBig depositBig);

    /**
     * 修改数据
     *
     * @param depositBig 实例对象
     * @return 影响行数
     */
    int update(DepositBig depositBig);

    /**
     * 提前取款
     * @param informid
     * @param money
     * @return
     */
    int updatemoney(@Param("informid") int informid,@Param("money") int money);
    /**
     * 通过主键删除数据
     *
     * @param depositBigid 主键
     * @return 影响行数
     */
    int deleteById(Integer depositBigid);

    /**
     * 根据用户id查看信息
     * @param userid
     * @return
     */
    List<DepositBig> getAllById(int userid);

    /**
     * 查今天的到期订单
     * @param today
     * @return
     */
    List<DepositBig> getAllNow(String today);

    /**
     * 根据id修改状态
     * @param informid
     * @return
     */
    int changestate(int informid);
}