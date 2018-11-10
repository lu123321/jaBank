package com.example.js_deposit_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.js_deposit_provider.entity.DepositInform;
import com.example.js_deposit_provider.dao.DepositInformDao;
import com.example.js_deposit_provider.service.DepositInformService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DepositInform)表服务实现类
 *
 * @author makejava
 * @since 2018-11-10 09:18:58
 */
@Service
public class DepositInformServiceImpl implements DepositInformService {
    @Resource
    private DepositInformDao depositInformDao;

    /**
     * 通过ID查询单条数据
     *
     * @param depositInformid 主键
     * @return 实例对象
     */
    @Override
    public DepositInform queryById(Integer depositInformid) {
        return this.depositInformDao.queryById(depositInformid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DepositInform> queryAllByLimit(int offset, int limit) {
        return this.depositInformDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param depositInform 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(DepositInform depositInform) {
        System.out.println(depositInform.getDepositInformnumber());
        return JSON.toJSONString(this.depositInformDao.insert(depositInform));
    }

    /**
     * 修改数据
     *
     * @param depositInform 实例对象
     * @return 实例对象
     */
    @Override
    public DepositInform update(DepositInform depositInform) {

        this.depositInformDao.update(depositInform);
        return this.queryById(depositInform.getDepositInformid());
    }

    /**
     * 通过主键删除数据
     *
     * @param depositInformid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer depositInformid) {
        return this.depositInformDao.deleteById(depositInformid) > 0;
    }
}