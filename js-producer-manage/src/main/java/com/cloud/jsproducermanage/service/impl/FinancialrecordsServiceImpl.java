package com.cloud.jsproducermanage.service.impl;

import com.cloud.jsproducermanage.entity.Financialrecords;
import com.cloud.jsproducermanage.dao.FinancialrecordsDao;
import com.cloud.jsproducermanage.service.FinancialrecordsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Financialrecords)表服务实现类
 *
 * @author makejava
 * @since 2018-11-10 08:53:18
 */
@Service("financialrecordsService")
public class FinancialrecordsServiceImpl implements FinancialrecordsService {
    @Resource
    private FinancialrecordsDao financialrecordsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param financialrecordsId 主键
     * @return 实例对象
     */
    @Override
    public Financialrecords queryById(Integer financialrecordsId) {
        return this.financialrecordsDao.queryById(financialrecordsId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Financialrecords> queryAllByLimit(int offset, int limit) {
        return this.financialrecordsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param financialrecords 实例对象
     * @return 实例对象
     */
    @Override
    public Financialrecords insert(Financialrecords financialrecords) {
        this.financialrecordsDao.insert(financialrecords);
        return financialrecords;
    }

    /**
     * 修改数据
     *
     * @param financialrecords 实例对象
     * @return 实例对象
     */
    @Override
    public Financialrecords update(Financialrecords financialrecords) {
        this.financialrecordsDao.update(financialrecords);
        return this.queryById(financialrecords.getFinancialrecordsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param financialrecordsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer financialrecordsId) {
        return this.financialrecordsDao.deleteById(financialrecordsId) > 0;
    }
}