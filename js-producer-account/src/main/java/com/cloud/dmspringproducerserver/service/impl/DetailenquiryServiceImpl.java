package com.cloud.dmspringproducerserver.service.impl;

import com.cloud.dmspringproducerserver.entity.Detailenquiry;
import com.cloud.dmspringproducerserver.dao.DetailenquiryDao;
import com.cloud.dmspringproducerserver.service.DetailenquiryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Detailenquiry)表服务实现类
 *
 * @author makejava
 * @since 2018-11-08 22:06:09
 */
@Service("detailenquiryService")
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