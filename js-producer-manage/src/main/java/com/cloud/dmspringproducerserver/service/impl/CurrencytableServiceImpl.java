package com.cloud.dmspringproducerserver.service.impl;

import com.cloud.dmspringproducerserver.entity.Currencytable;
import com.cloud.dmspringproducerserver.dao.CurrencytableDao;
import com.cloud.dmspringproducerserver.service.CurrencytableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Currencytable)表服务实现类
 *
 * @author makejava
 * @since 2018-11-08 22:11:34
 */
@Service("currencytableService")
public class CurrencytableServiceImpl implements CurrencytableService {
    @Resource
    private CurrencytableDao currencytableDao;

    /**
     * 通过ID查询单条数据
     *
     * @param currencytableId 主键
     * @return 实例对象
     */
    @Override
    public Currencytable queryById(Integer currencytableId) {
        return this.currencytableDao.queryById(currencytableId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Currencytable> queryAllByLimit(int offset, int limit) {
        return this.currencytableDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param currencytable 实例对象
     * @return 实例对象
     */
    @Override
    public Currencytable insert(Currencytable currencytable) {
        this.currencytableDao.insert(currencytable);
        return currencytable;
    }

    /**
     * 修改数据
     *
     * @param currencytable 实例对象
     * @return 实例对象
     */
    @Override
    public Currencytable update(Currencytable currencytable) {
        this.currencytableDao.update(currencytable);
        return this.queryById(currencytable.getCurrencytableId());
    }

    /**
     * 通过主键删除数据
     *
     * @param currencytableId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer currencytableId) {
        return this.currencytableDao.deleteById(currencytableId) > 0;
    }
}