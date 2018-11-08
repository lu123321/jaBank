package com.example.js_deposit_provider.service.impl;

import com.example.js_deposit_provider.entity.DepositFixation;
import com.example.js_deposit_provider.dao.DepositFixationDao;
import com.example.js_deposit_provider.service.DepositFixationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DepositFixation)表服务实现类
 *
 * @author makejava
 * @since 2018-11-08 10:32:29
 */
@Service
public class DepositFixationServiceImpl implements DepositFixationService {
    @Resource
    private DepositFixationDao depositFixationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param depositFixationid 主键
     * @return 实例对象
     */
    @Override
    public DepositFixation queryById(Integer depositFixationid) {
        return this.depositFixationDao.queryById(depositFixationid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DepositFixation> queryAllByLimit(int offset, int limit) {
        return this.depositFixationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param depositFixation 实例对象
     * @return 实例对象
     */
    @Override
    public DepositFixation insert(DepositFixation depositFixation) {
        this.depositFixationDao.insert(depositFixation);
        return depositFixation;
    }

    /**
     * 修改数据
     *
     * @param depositFixation 实例对象
     * @return 实例对象
     */
    @Override
    public DepositFixation update(DepositFixation depositFixation) {
        this.depositFixationDao.update(depositFixation);
        return this.queryById(depositFixation.getDepositFixationid());
    }

    /**
     * 通过主键删除数据
     *
     * @param depositFixationid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer depositFixationid) {
        return this.depositFixationDao.deleteById(depositFixationid) > 0;
    }
}