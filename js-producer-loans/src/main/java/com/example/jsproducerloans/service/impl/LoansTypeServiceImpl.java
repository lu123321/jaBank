package com.example.jsproducerloans.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducerloans.entity.LoansType;
import com.example.jsproducerloans.dao.LoansTypeDao;
import com.example.jsproducerloans.service.LoansTypeService;
import com.example.jsproducerloans.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (LoansType)表服务实现类
 *
 * @author makejava
 * @since 2018-11-20 11:01:16
 */
@Service
public class LoansTypeServiceImpl implements LoansTypeService {
    @Resource
    private LoansTypeDao loansTypeDao;
    @Resource
    private  RedisUtil redisUtil;
    /**
     * 通过ID查询单条数据
     *
     * @param loansTypeid 主键
     * @return 实例对象
     */
    @Override
    public LoansType queryById(Integer loansTypeid) {
        return this.loansTypeDao.queryById(loansTypeid);
    }

    /**
     * 获取所有的类型信息
     * @return
     */
    @Override
    public String getAllType() {
        if(redisUtil.hasKey("loanstype")){
            List<LoansType> loanstype = (List<LoansType>) redisUtil.get("loanstype");
            return JSON.toJSONString(loanstype);
        }else{
            List<LoansType> allType = loansTypeDao.getAllType();
            redisUtil.set("loanstype",allType);
            return JSON.toJSONString(allType);
        }
    }


    /**
     * 新增数据
     *
     * @param loansType 实例对象
     * @return 实例对象
     */
    @Override
    public LoansType insert(LoansType loansType) {
        this.loansTypeDao.insert(loansType);
        return loansType;
    }

    /**
     * 修改数据
     *
     * @param loansType 实例对象
     * @return 实例对象
     */
    @Override
    public LoansType update(LoansType loansType) {
        this.loansTypeDao.update(loansType);
        return this.queryById(loansType.getLoansTypeid());
    }

    /**
     * 通过主键删除数据
     *
     * @param loansTypeid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer loansTypeid) {
        return this.loansTypeDao.deleteById(loansTypeid) > 0;
    }
}