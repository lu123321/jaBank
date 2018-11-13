package com.example.jsproducermanagement.service;

import com.example.jsproducermanagement.entity.Bankuser;
import java.util.List;

/**
 * (Bankuser)表服务接口
 *
 * @author makejava
 * @since 2018-11-12 21:14:23
 */
public interface BankuserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    Bankuser queryById(Integer userid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Bankuser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bankuser 实例对象
     * @return 实例对象
     */
    Bankuser insert(Bankuser bankuser);

    /**
     * 修改数据
     *
     * @param bankuser 实例对象
     * @return 实例对象
     */
    Bankuser update(Bankuser bankuser);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userid);

}