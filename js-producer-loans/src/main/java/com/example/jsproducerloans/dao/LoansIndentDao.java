package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.entity.LoansIndent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (LoansIndent)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-17 17:23:48
 */
@Component
public interface LoansIndentDao {

    /**
     * 通过ID查询单条数据
     * @param loansIndentid 主键
     * @return 实例对象
     */
    LoansIndent queryById(Integer loansIndentid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LoansIndent> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param loansIndent 实例对象
     * @return 对象列表
     */
    List<LoansIndent> queryAll(LoansIndent loansIndent);

    /**
     * 新增数据
     *
     * @param loansIndent 实例对象
     * @return 影响行数
     */
    int insert(LoansIndent loansIndent);

    /**
     * 修改数据
     *
     * @param loansIndent 实例对象
     * @return 影响行数
     */
    int update(LoansIndent loansIndent);

    /**
     * 通过主键删除数据
     *
     * @param loansIndentid 主键
     * @return 影响行数
     */
    int deleteById(Integer loansIndentid);

    /**
     * 查用户下所有的贷款信息
     * @param userid
     * @return
     */
    List<LoansIndent> getAllUserId(int userid);

    /**
     * 根据订单id修改状态
     * @param informid
     * @return
     */
    int updatestate(int informid);

    /**
     * 订单完成后修改状态
     * @param informid
     * @return
     */
    int updatestate1(int informid);
    /**
     * 根据订单id查看关联卡号
     * @param informid
     * @return
     */
    String getcardByid(int informid);

    /**
     * 根据id查看订单利率
     * @param informid
     * @return
     */
    Double selLixi(int informid);
}