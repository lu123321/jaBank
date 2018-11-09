package com.cloud.dmspringproducerserver.service.impl;

import com.cloud.dmspringproducerserver.entity.Remittancetransaction;
import com.cloud.dmspringproducerserver.dao.RemittancetransactionDao;
import com.cloud.dmspringproducerserver.service.RemittancetransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Remittancetransaction)表服务实现类
 *
 * @author makejava
 * @since 2018-11-08 22:08:12
 */
@Service("remittancetransactionService")
public class RemittancetransactionServiceImpl implements RemittancetransactionService {
    @Resource
    private RemittancetransactionDao remittancetransactionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param remittancetransactionId 主键
     * @return 实例对象
     */
    @Override
    public Remittancetransaction queryById(Integer remittancetransactionId) {
        return this.remittancetransactionDao.queryById(remittancetransactionId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Remittancetransaction> queryAllByLimit(int offset, int limit) {
        return this.remittancetransactionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param remittancetransaction 实例对象
     * @return 实例对象
     */
    @Override
    public Remittancetransaction insert(Remittancetransaction remittancetransaction) {
        this.remittancetransactionDao.insert(remittancetransaction);
        return remittancetransaction;
    }

    /**
     * 修改数据
     *
     * @param remittancetransaction 实例对象
     * @return 实例对象
     */
    @Override
    public Remittancetransaction update(Remittancetransaction remittancetransaction) {
        this.remittancetransactionDao.update(remittancetransaction);
        return this.queryById(remittancetransaction.getRemittancetransactionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param remittancetransactionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer remittancetransactionId) {
        return this.remittancetransactionDao.deleteById(remittancetransactionId) > 0;
    }
}