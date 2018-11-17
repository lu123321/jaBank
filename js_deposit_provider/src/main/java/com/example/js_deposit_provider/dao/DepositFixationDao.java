package com.example.js_deposit_provider.dao;

import com.example.js_deposit_provider.entity.DepositFixation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * (DepositFixation)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-08 10:32:29
 */
@Component
public interface DepositFixationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param depositFixationid 主键
     * @return 实例对象
     */
    DepositFixation queryById(Integer depositFixationid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DepositFixation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param depositFixation 实例对象
     * @return 对象列表
     */
    List<DepositFixation> queryAll(DepositFixation depositFixation);

    /**
     * 新增数据
     *
     * @param depositFixation 实例对象
     * @return 影响行数
     */
    int insert(DepositFixation depositFixation);

    /**
     * 修改数据
     *
     * @param depositFixation 实例对象
     * @return 影响行数
     */
    int update(DepositFixation depositFixation);

    /**
     * 通过主键删除数据
     *
     * @param depositFixationid 主键
     * @return 影响行数
     */
    int deleteById(Integer depositFixationid);
    /**
     * 根据用户id查看订单信息
     * @param userid
     * @return
     */
    List<DepositFixation> getAllById(Integer userid);

    /**
     * 根据订单和金额取出相应的金钱
     * @param infromid
     * @param money
     * @return
     */
    int getMoney(@Param("informid") int infromid,@Param("money") int money);

    /**
     * 根据订单id查询余额
     * @param informid
     * @return
     */
   DepositFixation getYE(@Param("informid") int informid);

    /**
     * 获取当天到期表中所有
     * @return
     */
   List<DepositFixation> getAll(@Param("d") String d);
   /*
        根据id修改订单状态
    */
   int changeState(int informid);
}