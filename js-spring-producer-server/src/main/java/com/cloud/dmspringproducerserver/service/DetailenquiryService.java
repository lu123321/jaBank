package com.cloud.dmspringproducerserver.service;

import com.cloud.dmspringproducerserver.entity.Detailenquiry;
import java.util.List;

/**
 * (Detailenquiry)表服务接口
 *
 * @author makejava
 * @since 2018-11-08 22:06:09
 */
public interface DetailenquiryService {

    /**
     * 通过ID查询单条数据
     *
     * @param detailenquiryId 主键
     * @return 实例对象
     */
    Detailenquiry queryById(Integer detailenquiryId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Detailenquiry> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param detailenquiry 实例对象
     * @return 实例对象
     */
    Detailenquiry insert(Detailenquiry detailenquiry);

    /**
     * 修改数据
     *
     * @param detailenquiry 实例对象
     * @return 实例对象
     */
    Detailenquiry update(Detailenquiry detailenquiry);

    /**
     * 通过主键删除数据
     *
     * @param detailenquiryId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer detailenquiryId);

}