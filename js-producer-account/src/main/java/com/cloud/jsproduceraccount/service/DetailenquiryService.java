package com.cloud.jsproduceraccount.service;

import com.cloud.jsproduceraccount.entity.Detailenquiry;
import com.cloud.jsproduceraccount.service.pojovalue.Detailenvalue;

import java.util.List;

/**
 * (Detailenquiry)表服务接口
 *
 * @author makejava
 * @since 2018-11-10 08:50:36
 */
public interface DetailenquiryService {

    /**
     * 通过ID查询单条数据
     *
     * @param detailenquiryId 主键
     * @return 实例对象
     */
    String queryById(Integer detailenquiryId);

    /**
     * 根据卡号 时间 流出 支出情况 查询明细
     * @param
     * @param
     * @param
     * @return
     */
    String queryAll(Detailenvalue de);

    /**
     * 新增数据
     *
     * @param detailenquiry 实例对象
     * @return 实例对象
     */
    String insert(Detailenquiry detailenquiry);



    /**
     * 通过主键删除数据
     *
     * @param detailenquiryId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer detailenquiryId);

}