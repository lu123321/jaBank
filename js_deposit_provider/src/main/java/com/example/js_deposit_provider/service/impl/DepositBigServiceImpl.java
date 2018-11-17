package com.example.js_deposit_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.js_deposit_provider.entity.DepositBig;
import com.example.js_deposit_provider.dao.DepositBigDao;
import com.example.js_deposit_provider.entity.DepositBusiness;
import com.example.js_deposit_provider.entity.DepositFixation;
import com.example.js_deposit_provider.rabbitmq.RabbitConfig;
import com.example.js_deposit_provider.service.DepositBigService;
import com.example.js_deposit_provider.service.pojo.Qukuan;
import com.example.js_deposit_provider.util.DateUtil;
import com.example.js_deposit_provider.util.OrderNumberUtil;
import com.example.js_deposit_provider.util.RedisConfig;
import com.example.js_deposit_provider.util.RedisUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (DepositBig)表服务实现类
 *
 * @author makejava
 * @since 2018-11-16 19:58:52
 */
@Service
public class DepositBigServiceImpl implements DepositBigService {
    @Resource
    private DepositBigDao depositBigDao;
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private RabbitTemplate rabbitTemplate;
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
    public String insert(DepositBig depositBig) {
        if(depositBig.getDepositBigbustype() != null && depositBig.getDepositBigcardid() != null && depositBig.getDepositBiglv() != null && depositBig.getDepositBigmoney() != null && depositBig.getDepositBiguserid() != null){
            String nowDate = DateUtil.getNowDate();
            //获得当前时间
            Date indate = DateUtil.SchangeD(nowDate);
            //获得到期时间
            Map<Object, Object> hmget = redisUtil.hmget("3");
            DepositBusiness d  = (DepositBusiness) hmget.get(depositBig.getDepositBigbustype().toString());
            Date getfuture = DateUtil.getfuture(indate, d.getDepositBusinesslong());
            depositBig.setDepositBigintime(indate);
            depositBig.setDepositBigouttime(getfuture);
            depositBig.setDepositBigState(0);
            depositBig.setDepositBignumber(OrderNumberUtil.createNumber(depositBig.getDepositBiguserid().toString()));
            depositBig.setDepositBiglong(d.getDepositBusinesslong());
            depositBigDao.insert(depositBig);
            return "200";
        }else{
            return "400";
        }
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

    /**
     * 根据用户id查看订单信息
     * @param userid
     * @return
     */
    @Override
    public String getAllById(String userid) {
        try {
            if(userid != "" && userid != null){
                int i = Integer.parseInt(userid);
                List<DepositBig> allById = depositBigDao.getAllById(i);
                if(allById.size() > 0){
                    return JSON.toJSONString(allById);
                }else{
                    return "101"; //用户不存在订单
                }
            }else {
                return "400"; //参数为空
            }
        }catch (Exception e){
            return "400"; //参数格式不对
        }
    }

    /**
     * 提前取款
     * @param informid
     * @param money
     * @return
     */
    @Override
    public String getMoney(String informid, String money) {
        try {
            List<Qukuan> qlist = new ArrayList<Qukuan>();
            if (informid != null && informid != "" && money != null && money != "") {
                int i = Integer.parseInt(informid);
                int mon = Integer.parseInt(money);
                DepositBig depositBig = depositBigDao.queryById(i);
                if (depositBig.getDepositBigmoney() > mon) {
                    int updatemoney = depositBigDao.updatemoney(i, mon);
                    if (updatemoney > 0) {
                        Qukuan qukuan = new Qukuan();
                        qukuan.setMoney(mon * 0.3);
                        qukuan.setCardid(depositBig.getDepositBigcardid());
                        qukuan.setBusinessRate(0.3);
                        qukuan.setBusinessName("大额存款取款");
                        qukuan.setState(1);
                        qlist.add(qukuan);
                        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_WITHDRAWAL, JSON.toJSONString(qlist));
                        return "200";
                    } else {
                        return "101"; //取钱出错
                    }
                } else {
                    return "余额不足";
                }
            } else {
                return "400";
            }
        }catch (Exception e){
            return "102"; //参数格式错误
        }
    }
    @Scheduled(cron = "0 0 1 * * ?")
    public void expireInform(){
        List<Qukuan> qlist = new ArrayList<Qukuan>();
        String nowDate = DateUtil.getNowDate();
        List<DepositBig> allNow = depositBigDao.getAllNow(nowDate);
        Map<Object, Object> hmget = redisUtil.hmget("3");
        for (DepositBig d : allNow){
            depositBigDao.changestate(d.getDepositBigid());
            Qukuan q = new Qukuan();
            q.setState(1);
            q.setCardid(d.getDepositBigcardid());
            Double lv = d.getDepositBiglv();
            q.setBusinessRate(lv);
            q.setBusinessName("大额存款取款");
            q.setMoney(d.getDepositBigmoney() + ((d.getDepositBigmoney() * lv*0.01)*(d.getDepositBiglong()/12)));
            qlist.add(q);
        }
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_WITHDRAWAL,JSON.toJSONString(qlist));
    }
}