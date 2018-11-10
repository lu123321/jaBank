package com.example.js_deposit_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.js_deposit_provider.entity.DepositBusiness;
import com.example.js_deposit_provider.dao.DepositBusinessDao;
import com.example.js_deposit_provider.service.DepositBusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DepositBusiness)表服务实现类
 *
 * @author makejava
 * @since 2018-11-10 09:18:59
 */
@Service
public class DepositBusinessServiceImpl implements DepositBusinessService {
    @Resource
    private DepositBusinessDao depositBusinessDao;

    /**
     * 通过ID查询单条数据
     *
     * @param depositBusinessid 主键
     * @return 实例对象
     */
    @Override
    public DepositBusiness queryById(Integer depositBusinessid) {
        return this.depositBusinessDao.queryById(depositBusinessid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DepositBusiness> queryAllByLimit(int offset, int limit) {
        return this.depositBusinessDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param depositBusiness 实例对象
     * @return 实例对象
     */
    @Override
    public DepositBusiness insert(DepositBusiness depositBusiness) {
        this.depositBusinessDao.insert(depositBusiness);
        return depositBusiness;
    }

    /**
     * 修改数据
     *
     * @param depositBusiness 实例对象
     * @return 实例对象
     */
    @Override
    public DepositBusiness update(DepositBusiness depositBusiness) {
        this.depositBusinessDao.update(depositBusiness);
        return this.queryById(depositBusiness.getDepositBusinessid());
    }

    /**
     * 通过主键删除数据
     *
     * @param depositBusinessid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer depositBusinessid) {
        return this.depositBusinessDao.deleteById(depositBusinessid) > 0;
    }

    @Override
    public String getByType(String typeid) {
        try{
            if(typeid != null && typeid != ""){
                List<DepositBusiness> byType = depositBusinessDao.getByType(Integer.parseInt(typeid));
                return JSON.toJSONString(byType);
            }else {
                return "404";
            }
        }catch (Exception e){
            return "404";
        }
    }
}