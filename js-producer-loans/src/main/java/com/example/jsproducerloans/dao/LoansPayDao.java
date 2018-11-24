package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.entity.LoansPay;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (LoansPay)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-22 22:47:19
 */
@Component
public interface LoansPayDao {

    /**
     * 通过ID查询单条数据
     *
     * @param loansPayid 主键
     * @return 实例对象
     */
    LoansPay queryById(Integer loansPayid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LoansPay> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param loansPay 实例对象
     * @return 对象列表
     */
    List<LoansPay> queryAll(LoansPay loansPay);

    /**
     * 新增数据
     *
     * @param loansPay 实例对象
     * @return 影响行数
     */
    int insert(LoansPay loansPay);

    /**
     * 修改数据
     *
     * @param loansPay 实例对象
     * @return 影响行数
     */
    int update(LoansPay loansPay);

    /**
     * 根据订单信息修改信息
     * @param loansRegbenjin
     * @param loansLixi
     * @param loansIndentid
     * @return
     */
    Integer updatemoney(@Param("loansRegbenjin") Double loansRegbenjin,@Param("loansLixi") Double loansLixi,@Param("loansIndentid") int loansIndentid);
    /**
     * 通过主键删除数据
     *
     * @param loansPayid 主键
     * @return 影响行数
     */
    int deleteById(Integer loansPayid);

    /**
     * 根据订单id进行删除
     * @param informid
     * @return
     */
    int deleteByImform(Integer informid);
    /**
     * 根据订单信息查看用户已还的本金
     * @param informid
     * @return
     */
    Double queryByInformId(Integer informid);
}