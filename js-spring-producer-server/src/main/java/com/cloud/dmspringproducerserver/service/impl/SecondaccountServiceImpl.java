package com.cloud.dmspringproducerserver.service.impl;

import com.cloud.dmspringproducerserver.entity.Secondaccount;
import com.cloud.dmspringproducerserver.dao.SecondaccountDao;
import com.cloud.dmspringproducerserver.service.SecondaccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Secondaccount)表服务实现类
 *
 * @author makejava
 * @since 2018-11-08 22:07:20
 */
@Service("secondaccountService")
public class SecondaccountServiceImpl implements SecondaccountService {
    @Resource
    private SecondaccountDao secondaccountDao;

    /**
     * 通过ID查询单条数据
     *
     * @param accountId 主键
     * @return 实例对象
     */
    @Override
    public Secondaccount queryById(Integer accountId) {
        return this.secondaccountDao.queryById(accountId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Secondaccount> queryAllByLimit(int offset, int limit) {
        return this.secondaccountDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param secondaccount 实例对象
     * @return 实例对象
     */
    @Override
    public Secondaccount insert(Secondaccount secondaccount) {
        this.secondaccountDao.insert(secondaccount);
        return secondaccount;
    }

    /**
     * 修改数据
     *
     * @param secondaccount 实例对象
     * @return 实例对象
     */
    @Override
    public Secondaccount update(Secondaccount secondaccount) {
        this.secondaccountDao.update(secondaccount);
        return this.queryById(secondaccount.getAccountId());
    }

    /**
     * 通过主键删除数据
     *
     * @param accountId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer accountId) {
        return this.secondaccountDao.deleteById(accountId) > 0;
    }
}