package com.cloud.jsproducerremittance.service.impl;

import com.cloud.jsproducerremittance.entity.Makeremittance;
import com.cloud.jsproducerremittance.dao.MakeremittanceDao;
import com.cloud.jsproducerremittance.service.MakeremittanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Makeremittance)表服务实现类
 *
 * @author makejava
 * @since 2018-11-10 08:51:56
 */
@Service
public class MakeremittanceServiceImpl implements MakeremittanceService {
    @Resource
    private MakeremittanceDao makeremittanceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param makeremittanceId 主键
     * @return 实例对象
     */
    @Override
    public Makeremittance queryById(Integer makeremittanceId) {
        return this.makeremittanceDao.queryById(makeremittanceId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Makeremittance> queryAllByLimit(int offset, int limit) {
        return this.makeremittanceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param makeremittance 实例对象
     * @return 实例对象
     */
    @Override
    public Makeremittance insert(Makeremittance makeremittance) {
        this.makeremittanceDao.insert(makeremittance);
        return makeremittance;
    }

    /**
     * 修改数据
     *
     * @param makeremittance 实例对象
     * @return 实例对象
     */
    @Override
    public Makeremittance update(Makeremittance makeremittance) {
        this.makeremittanceDao.update(makeremittance);
        return this.queryById(makeremittance.getMakeremittanceId());
    }

    /**
     * 通过主键删除数据
     *
     * @param makeremittanceId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer makeremittanceId) {
        return this.makeremittanceDao.deleteById(makeremittanceId) > 0;
    }
}