package com.cloud.dmspringproducerserver.service.impl;

import com.cloud.dmspringproducerserver.entity.Financialtypelist;
import com.cloud.dmspringproducerserver.dao.FinancialtypelistDao;
import com.cloud.dmspringproducerserver.service.FinancialtypelistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Financialtypelist)表服务实现类
 *
 * @author makejava
 * @since 2018-11-08 22:11:00
 */
@Service("financialtypelistService")
public class FinancialtypelistServiceImpl implements FinancialtypelistService {
    @Resource
    private FinancialtypelistDao financialtypelistDao;

    /**
     * 通过ID查询单条数据
     *
     * @param financialtypelistId 主键
     * @return 实例对象
     */
    @Override
    public Financialtypelist queryById(Integer financialtypelistId) {
        return this.financialtypelistDao.queryById(financialtypelistId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Financialtypelist> queryAllByLimit(int offset, int limit) {
        return this.financialtypelistDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param financialtypelist 实例对象
     * @return 实例对象
     */
    @Override
    public Financialtypelist insert(Financialtypelist financialtypelist) {
        this.financialtypelistDao.insert(financialtypelist);
        return financialtypelist;
    }

    /**
     * 修改数据
     *
     * @param financialtypelist 实例对象
     * @return 实例对象
     */
    @Override
    public Financialtypelist update(Financialtypelist financialtypelist) {
        this.financialtypelistDao.update(financialtypelist);
        return this.queryById(financialtypelist.getFinancialtypelistId());
    }

    /**
     * 通过主键删除数据
     *
     * @param financialtypelistId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer financialtypelistId) {
        return this.financialtypelistDao.deleteById(financialtypelistId) > 0;
    }
}