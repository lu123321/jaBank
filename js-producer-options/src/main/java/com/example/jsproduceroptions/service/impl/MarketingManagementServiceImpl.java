package com.example.jsproduceroptions.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproduceroptions.dao.MarketingManagementDao;
import com.example.jsproduceroptions.entity.MarketingManagement;
import com.example.jsproduceroptions.service.MarketingManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (MarketingManagement)表服务实现类
 *
 * @author makejava
 * @since 2018-11-08 16:01:18
 */
@Service
public class MarketingManagementServiceImpl implements MarketingManagementService {
    @Autowired
    private MarketingManagementDao marketingManagementDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public String queryById(Integer userId,Integer number) {
        MarketingManagement marketingManagement = marketingManagementDao.queryById(userId, number);
        return JSON.toJSONString(marketingManagement);
    }

    /**
     * 通过用户id查询所有信息
     *
     * @param userId 实例对象
     * @return 对象列表
     */
    @Override
    public List<MarketingManagement> queryAll(Integer userId) {
        return this.marketingManagementDao.queryAll(userId);
    }

    /**
     * 新增数据
     *
     * @param userId,name,marketing,phone,state 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Integer userId,String name,String marketing,String phone,Integer state) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        MarketingManagement m = new MarketingManagement();
        if("".equals(name) || "".equals(marketing) || "".equals(phone)){
            return "301";
        }else {
            if(marketing.length() == 9 && phone.length() == 11){
                Pattern compile = Pattern.compile(regex);
                Matcher matcher = compile.matcher(phone);
                boolean matches = matcher.matches();
                if(!matches){
                    return "302";
                }else {
                    m.setNumber(0);
                    m.setUserId(userId);
                    m.setName(name);
                    m.setMarketing(marketing);
                    m.setPhone(phone);
                    m.setState(state);
                    marketingManagementDao.insert(m);
                    return "201";
                }
            }else {
                return "301";
            }
        }
    }

    /**
     * 修改数据
     *
     * @param marketingManagement 实例对象
     * @return 实例对象
     */
    @Override
    public String update(MarketingManagement marketingManagement){
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        MarketingManagement m = new MarketingManagement();
        if("".equals(marketingManagement.getName()) || "".equals(marketingManagement.getMarketing()) || "".equals(marketingManagement.getPhone())){
            return "303";
        }else {
            if (marketingManagement.getMarketing().length() == 9 && marketingManagement.getPhone().length() == 11) {
                Pattern compile = Pattern.compile(regex);
                Matcher matcher = compile.matcher(marketingManagement.getPhone());
                boolean matches = matcher.matches();
                if (!matches) {
                    return "302";
                } else {
                    m.setUserId(marketingManagement.getUserId());
                    m.setNumber(marketingManagement.getNumber());
                    m.setName(marketingManagement.getName());
                    m.setMarketing(marketingManagement.getMarketing());
                    m.setPhone(marketingManagement.getPhone());
                    m.setState(marketingManagement.getState());
                    marketingManagementDao.update(m);
                    return "204";
                }
            } else {
                return "304";
            }
        }
    }


    /**
     * 通过主键删除数据
     *
     * @param userId 和 number 删除
     * @return 是否成功
     */
    @Override
    public String deleteById(Integer userId,Integer number) {
        marketingManagementDao.deleteById(userId,number);
        return "203";
    }
}