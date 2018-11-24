package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.entity.LoansBus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (LoansBus)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-20 11:01:16
 */
@Component
public interface LoansBusDao {

    /**
     * 通过ID查询单条数据
     *
     * @param loansBusid 主键
     * @return 实例对象
     */
    LoansBus queryById(Integer loansBusid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LoansBus> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param loansBus 实例对象
     * @return 对象列表
     */
    List<LoansBus> queryAll(LoansBus loansBus);

    /**
     * 新增数据
     *
     * @param loansBus 实例对象
     * @return 影响行数
     */
    int insert(LoansBus loansBus);

    /**
     * 修改数据
     *
     * @param loansBus 实例对象
     * @return 影响行数
     */
    int update(LoansBus loansBus);

    /**
     * 通过主键删除数据
     *
     * @param loansBusid 主键
     * @return 影响行数
     */
    int deleteById(Integer loansBusid);

    /**
     * 根据业务大类型查看所有笑类型
     * @param typeid
     * @return
     */
    List<LoansBus> getbusByType(int typeid);

}