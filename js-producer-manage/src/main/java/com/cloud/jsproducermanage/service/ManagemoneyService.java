package com.cloud.jsproducermanage.service;

import com.cloud.jsproducermanage.entity.Managemoney;
import java.util.List;

/**
 * (Managemoney)表服务接口
 *
 * @author makejava
 * @since 2018-11-10 08:52:39
 */
public interface ManagemoneyService {

    /**
     * 通过ID查询单条数据
     *
     * @param managemoneyId 主键
     * @return 实例对象
     */
    Managemoney queryById(Integer managemoneyId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Managemoney> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param managemoney 实例对象
     * @return 实例对象
     */
    Managemoney insert(Managemoney managemoney);

    /**
     * 修改数据
     *
     * @param managemoney 实例对象
     * @return 实例对象
     */
    Managemoney update(Managemoney managemoney);

    /**
     * 通过主键删除数据
     *
     * @param managemoneyId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer managemoneyId);

}