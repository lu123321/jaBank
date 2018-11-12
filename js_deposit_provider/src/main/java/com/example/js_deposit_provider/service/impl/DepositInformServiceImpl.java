package com.example.js_deposit_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.js_deposit_provider.entity.DepositInform;
import com.example.js_deposit_provider.dao.DepositInformDao;
import com.example.js_deposit_provider.service.DepositInformService;
import com.example.js_deposit_provider.service.pojo.Qukuan;
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
        //此处还需要进行银行存款金额进行变化
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
     * 普通取款
     * @param informid
     * @param money
     * @return
     */
    @Override
    public String withdrawal(String informid, String money) {
        if(informid != null && informid != "" && money != null && money != ""){
            DepositInform depositInform = depositInformDao.selMoney(Integer.parseInt(informid));
            int i1 = Integer.parseInt(money);
            Integer depositInformmoney = depositInform.getDepositInformmoney();
            if(depositInformmoney>i1){
                 depositInformDao.withdrawal(Integer.parseInt(informid),depositInformmoney-i1);
                 Qukuan qukuan = new Qukuan();
                 qukuan.setCardid(depositInform.getDepositInformcardid());
                 qukuan.setMoney(money);
                 return JSON.toJSONString(qukuan); //返回卡号和金额，调用个人信息增加金额的接口；
                 //取款成功
            }else{
                return "101"; //余额不足
            }
        }else {
            return "400"; //参数错误
        }
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

    @Override
    public String getInformByUserid(String userid) {
        if(userid != null && userid != ""){
            List<DepositInform> infomByUserid = depositInformDao.getInfomByUserid(userid);
            if(infomByUserid.size() >0){
                return JSON.toJSONString(infomByUserid);
            }else {
                return "101"; //不存在存款信息
            }
        }else{
            return "102"; //没有用户id或用户未登陆
        }
    }
}