package com.cloud.dmspringproducerserver.service.impl;

import com.cloud.dmspringproducerserver.entity.Batch;
import com.cloud.dmspringproducerserver.dao.BatchDao;
import com.cloud.dmspringproducerserver.service.BatchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Batch)表服务实现类
 *
 * @author makejava
 * @since 2018-11-08 22:09:08
 */
@Service("batchService")
public class BatchServiceImpl implements BatchService {
    @Resource
    private BatchDao batchDao;

    /**
     * 通过ID查询单条数据
     *
     * @param batchId 主键
     * @return 实例对象
     */
    @Override
    public Batch queryById(Integer batchId) {
        return this.batchDao.queryById(batchId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Batch> queryAllByLimit(int offset, int limit) {
        return this.batchDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param batch 实例对象
     * @return 实例对象
     */
    @Override
    public Batch insert(Batch batch) {
        this.batchDao.insert(batch);
        return batch;
    }

    /**
     * 修改数据
     *
     * @param batch 实例对象
     * @return 实例对象
     */
    @Override
    public Batch update(Batch batch) {
        this.batchDao.update(batch);
        return this.queryById(batch.getBatchId());
    }

    /**
     * 通过主键删除数据
     *
     * @param batchId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer batchId) {
        return this.batchDao.deleteById(batchId) > 0;
    }
}