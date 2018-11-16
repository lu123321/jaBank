package com.cloud.jsproduceraccount.service.impl;

import com.alibaba.fastjson.JSON;
import com.cloud.jsproduceraccount.entity.Detailenquiry;
import com.cloud.jsproduceraccount.dao.DetailenquiryDao;
import com.cloud.jsproduceraccount.service.DetailenquiryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Detailenquiry)表服务实现类
 *
 * @author makejava
 * @since 2018-11-10 08:50:36
 */
@Service
public class DetailenquiryServiceImpl implements DetailenquiryService {
    @Resource
    private DetailenquiryDao detailenquiryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param detailenquiryId 主键
     * @return 实例对象
     */
    @Override
    public String queryById(Integer detailenquiryId) {
        return JSON.toJSONString(this.detailenquiryDao.queryById(detailenquiryId));
    }

    /**
     * 根据卡号 时间 流出 支出情况 查询明细
     * @param detailenquiryNumber
     * @param detailenquiryDataS
     * @param detailenquiryFundflow
     * @return
     */
    @Override
    public String queryAll(String detailenquiryNumber, String detailenquiryDataS, String detailenquiryFundflow) {
        List<Detailenquiry> detailenquiries = detailenquiryDao.queryAll(detailenquiryNumber, detailenquiryDataS, detailenquiryFundflow);
        return JSON.toJSONString(detailenquiries);
    }


    /**
     * 新增数据
     *
     * @param detailenquiry 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Detailenquiry detailenquiry) {
        int insert = this.detailenquiryDao.insert(detailenquiry);
        if (insert > 0){
            return "200";
        }
        return "500";
    }



    /**
     * 通过主键删除数据
     *
     * @param detailenquiryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer detailenquiryId) {
        return this.detailenquiryDao.deleteById(detailenquiryId) > 0;
    }
}