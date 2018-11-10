package com.example.js_deposit_provider.service.impl;

import com.example.js_deposit_provider.entity.DepositBig;
import com.example.js_deposit_provider.dao.DepositBigDao;
import com.example.js_deposit_provider.service.DepositBigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DepositBig)表服务实现类
 *
 * @author makejava
 * @since 2018-11-08 10:32:28
 */
@Service
public class DepositBigServiceImpl implements DepositBigService {
    @Resource
    private DepositBigDao depositBigDao;

    /**
     * 通过ID查询单条数据
     *
     * @param depositBigid 主键
     * @return 实例对象
     */
    @Override
    public DepositBig queryById(Integer depositBigid) {
        return this.depositBigDao.queryById(depositBigid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DepositBig> queryAllByLimit(int offset, int limit) {
        return this.depositBigDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param depositBig 实例对象
     * @return 实例对象
     */
    @Override
    public DepositBig insert(DepositBig depositBig) {
        this.depositBigDao.insert(depositBig);
        return depositBig;
    }

    /**
     * 修改数据
     *
     * @param depositBig 实例对象
     * @return 实例对象
     */
    @Override
    public DepositBig update(DepositBig depositBig) {
        this.depositBigDao.update(depositBig);
        return this.queryById(depositBig.getDepositBigid());
    }

    /**
     * 通过主键删除数据
     *
     * @param depositBigid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer depositBigid) {
        return this.depositBigDao.deleteById(depositBigid) > 0;
    }
}