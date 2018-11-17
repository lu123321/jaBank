package com.example.js_deposit_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.js_deposit_provider.entity.DepositBusiness;
import com.example.js_deposit_provider.entity.DepositFixation;
import com.example.js_deposit_provider.dao.DepositFixationDao;
import com.example.js_deposit_provider.rabbitmq.RabbitConfig;
import com.example.js_deposit_provider.service.DepositFixationService;
import com.example.js_deposit_provider.service.pojo.Qukuan;
import com.example.js_deposit_provider.util.DateUtil;
import com.example.js_deposit_provider.util.OrderNumberUtil;
import com.example.js_deposit_provider.util.RedisUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Resource
    private  RedisUtil redisUtil;
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
     * @param dep 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(DepositFixation dep) {
        if(dep.getDepositFixationbusinesstype() != null && dep.getDepositFixationcardid() != null && dep.getDeposit_fixationLv() != null && dep.getDepositFixationmoney() != null && dep.getDepositFixationuserid() != null){
            //在消费者放先判断卡中余额是否足够，足够先扣除卡中余额再进行订单生成操作
            String nowDate = DateUtil.getNowDate();
            //获得当前时间
            Date indate = DateUtil.SchangeD(nowDate);
            //获得到期时间
            Map<Object, Object> hmget = redisUtil.hmget("2");
            DepositBusiness o = (DepositBusiness) hmget.get(dep.getDepositFixationbusinesstype());
            System.out.println(o);
            System.out.println(dep.getDepositFixationbusinesstype());
            Date getfuture = DateUtil.getfuture(indate, o.getDepositBusinesslong());
            dep.setDepositFixationintime(indate);
            dep.setDepositFixationouttime(getfuture);
            dep.setDepositFixationnumber(OrderNumberUtil.createNumber(dep.getDepositFixationuserid().toString()));
            dep.setDepositState(0);
            //执行增加订单信息操作
            int insert = this.depositFixationDao.insert(dep);
            return "200";
        }else{
            return "400";
        }

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
                List<DepositFixation> allById = depositFixationDao.getAllById(i);
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
     * 根据订单和金钱进行普通取款
     * @param infromid
     * @param money
     * @return
     */
    @Override
    public String getmoney(String infromid, String money) {
        List<Qukuan> qlist = new ArrayList<Qukuan>();
        try {
            if(infromid != null && infromid != "" && money != null && money != ""){
                int i = Integer.parseInt(infromid);
                int mon = Integer.parseInt(money);
                DepositFixation yue = depositFixationDao.getYE(i);
                if(yue.getDepositFixationmoney() > mon){
                    int money1 = depositFixationDao.getMoney(i, mon);
                    if(money1 >0){
                        Qukuan qukuan = new Qukuan();
                        qukuan.setMoney(mon*0.3);
                        qukuan.setCardid(yue.getDepositFixationcardid());
                        qukuan.setBusinessRate(0.3);
                        qukuan.setBusinessName("定期存款取款");
                        qukuan.setState(1);
                        qlist.add(qukuan);
                        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_WITHDRAWAL,JSON.toJSONString(qlist));
                        return "200";
                    }else {
                        return "101"; //取钱出错
                    }
                }else{
                    return "余额不足"; //
                }
            }else{
                return "400"; //参数为空
            }
        }catch (Exception e){
            return  "400"; //参数格式错误
        }
    }
    @Scheduled(cron = "0 0 1 * * ?")
    public void expireInform(){
        List<Qukuan> qlist = new ArrayList<Qukuan>();
        String nowDate = DateUtil.getNowDate();
        List<DepositFixation> all = depositFixationDao.getAll(nowDate);
        Map<Object, Object> hmget = redisUtil.hmget("2");
        for (DepositFixation d:all) {
            depositFixationDao.changeState(d.getDepositFixationid());
            DepositBusiness o = (DepositBusiness) hmget.get(d.getDepositFixationbusinesstype());
            Integer timelong = o.getDepositBusinesslong();
            Qukuan q = new Qukuan();
            q.setState(1);
            q.setBusinessName("定期存款到期");
            Double deposit_fixationLv = d.getDeposit_fixationLv();
            q.setBusinessRate(deposit_fixationLv);
            q.setCardid(d.getDepositFixationcardid());
            Double depositFixationmoney = d.getDepositFixationmoney();
            q.setMoney(depositFixationmoney + ((depositFixationmoney*deposit_fixationLv*0.01)*(timelong/12)));
            qlist.add(q);
        }
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_WITHDRAWAL,JSON.toJSONString(qlist));
    }
}