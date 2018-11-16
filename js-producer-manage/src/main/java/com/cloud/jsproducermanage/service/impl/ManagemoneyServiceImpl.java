package com.cloud.jsproducermanage.service.impl;

import com.cloud.jsproducermanage.entity.Managemoney;
import com.cloud.jsproducermanage.dao.ManagemoneyDao;
import com.cloud.jsproducermanage.service.ManagemoneyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Managemoney)表服务实现类
 *
 * @author makejava
 * @since 2018-11-10 08:52:39
 */
@Service("managemoneyService")
public class ManagemoneyServiceImpl implements ManagemoneyService {
    @Resource
    private ManagemoneyDao managemoneyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param managemoneyId 主键
     * @return 实例对象
     */
    @Override
    public Managemoney queryById(Integer managemoneyId) {
        return this.managemoneyDao.queryById(managemoneyId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Managemoney> queryAllByLimit(int offset, int limit) {
        return this.managemoneyDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param managemoney 实例对象
     * @return 实例对象
     */
    @Override
    public Managemoney insert(Managemoney managemoney) {
        this.managemoneyDao.insert(managemoney);
        return managemoney;
    }

    /**
     * 修改数据
     *
     * @param managemoney 实例对象
     * @return 实例对象
     */
    @Override
    public Managemoney update(Managemoney managemoney) {
        this.managemoneyDao.update(managemoney);
        return this.queryById(managemoney.getManagemoneyId());
    }

    /**
     * 通过主键删除数据
     *
     * @param managemoneyId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer managemoneyId) {
        return this.managemoneyDao.deleteById(managemoneyId) > 0;
    }
}