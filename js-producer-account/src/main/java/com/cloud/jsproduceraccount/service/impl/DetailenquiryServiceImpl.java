package com.cloud.jsproduceraccount.service.impl;

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
    public Detailenquiry queryById(Integer detailenquiryId) {
        return this.detailenquiryDao.queryById(detailenquiryId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Detailenquiry> queryAllByLimit(int offset, int limit) {
        return this.detailenquiryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param detailenquiry 实例对象
     * @return 实例对象
     */
    @Override
    public Detailenquiry insert(Detailenquiry detailenquiry) {
        this.detailenquiryDao.insert(detailenquiry);
        return detailenquiry;
    }

    /**
     * 修改数据
     *
     * @param detailenquiry 实例对象
     * @return 实例对象
     */
    @Override
    public Detailenquiry update(Detailenquiry detailenquiry) {
        this.detailenquiryDao.update(detailenquiry);
        return this.queryById(detailenquiry.getDetailenquiryId());
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