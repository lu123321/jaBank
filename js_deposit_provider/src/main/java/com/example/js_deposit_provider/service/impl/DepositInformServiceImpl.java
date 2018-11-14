package com.example.js_deposit_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.js_deposit_provider.dao.DepositBusinessDao;
import com.example.js_deposit_provider.dao.DepositWithdrawalDao;
import com.example.js_deposit_provider.entity.DepositBusiness;
import com.example.js_deposit_provider.entity.DepositInform;
import com.example.js_deposit_provider.dao.DepositInformDao;
import com.example.js_deposit_provider.entity.DepositWithdrawal;
import com.example.js_deposit_provider.rabbitmq.RabbitConfig;
import com.example.js_deposit_provider.service.DepositInformService;
import com.example.js_deposit_provider.service.pojo.Qukuan;
import com.example.js_deposit_provider.util.DateUtil;
import com.example.js_deposit_provider.util.OrderNumberUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.*;

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
    @Resource
    private DepositBusinessDao depositBusinessdao;
    @Resource
    private DepositWithdrawalDao depositWithdrawalDao;
    @Autowired
    private RabbitTemplate rabbitTemplate;
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
        String nowDate = DateUtil.getNowDate();
        System.out.println(nowDate);
        Date date = DateUtil.SchangeD(nowDate);
        depositInform.setDepositInformstate("0");
        depositInform.setDepositInformtime(date);
        depositInform.setDepositInformnumber(OrderNumberUtil.createNumber(depositInform.getDepositInformuserid()));
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
        List<Qukuan> qk = new ArrayList<Qukuan>();
        if(informid != null && informid != "" && money != null && money != ""){
            //获得存款金额
            DepositInform depositInform = depositInformDao.selMoney(Integer.parseInt(informid));
            int i1 = Integer.parseInt(money);
            Integer depositInformmoney = depositInform.getDepositInformmoney();
            //进行比较
            if(depositInformmoney>i1){
                 //进行存款减少
                depositInformDao.withdrawal(Integer.parseInt(informid),i1);
                DepositBusiness business = depositBusinessdao.queryById(depositInform.getDepositInformtype());
                String depositBusinessrate = business.getDepositBusinessrate();
                double v = Double.parseDouble(depositBusinessrate);
                Date depositInformtime = depositInform.getDepositInformtime();
                String nowDate = DateUtil.getNowDate();
                String s = DateUtil.DchangeS(depositInformtime);
                long daySub = DateUtil.getDaySub(s, nowDate);
                Qukuan qukuan = new Qukuan();
                qukuan.setBusinessName(business.getDepositBusinessname());
                qukuan.setBusinessRate(v);
                qukuan.setCardid(depositInform.getDepositInformcardid());
                double mon = (i1+((i1*v*0.01)*daySub)/365);
                DecimalFormat df = new DecimalFormat(".00");
                double x = Double.parseDouble(df.format(mon));
                qukuan.setMoney(x);
                qk.add(qukuan);
                rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_WITHDRAWAL,JSON.toJSONString(qk));
                return "200"; //返回卡号和金额，调用个人信息增加金额的接口；
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

    /**
     * 预约存款接口
     * @param inforid //订单id
     * @param money  //取款金额
     * @param begintime // 预约开始时间
     * @param endtime //预约结束时间
     * @return
     */
    @Override
    public String subwithdrawal(String inforid, String money, String begintime, String endtime) {
        //先将预约存款信息存入表中
        if(inforid != null && inforid != "" && money != null && money != "" && begintime != null && begintime != "" && endtime != null && endtime != "" ){
            DepositWithdrawal dep = new DepositWithdrawal();
            dep.setDepositWithdrawalorderid(Integer.parseInt(inforid));
            dep.setDepositWithdrawalmoney(Integer.parseInt(money));
            dep.setDepositWithdrawalstate(0);
            //此处需要从redis中取出用户对象，得到用户id，存入dep对象
            dep.setDepositWithdrawalintime(DateUtil.SchangeD(begintime));
            dep.setDepositWithdrawaouttime(DateUtil.SchangeD(endtime));
            int insert = depositWithdrawalDao.insert(dep);
            if(insert > 0){
                DepositInform depositInform = new DepositInform();
                depositInform.setDepositInformid(Integer.parseInt(inforid));
                depositInform.setDepositInformstate("1");
                depositInformDao.update(depositInform);
                return "200"; //通知存款申请成功
            }else {
                return "400"; //申请失败
            }
        }else {
            return  "400"; //参数错误，申请失败
        }
    }

    /**
     * 定时任务进行预约取款处理
     */
    @Override
    @Scheduled(cron = "0 0 2 * * ?")
    public void Allwithdrawal(){
        Map<Integer,DepositWithdrawal> changeList = new HashMap<Integer, DepositWithdrawal>();
        //得到所有预约信息
        List<DepositWithdrawal> all = depositWithdrawalDao.getAll();
        List<Qukuan> returnQk = new ArrayList<Qukuan>();
        String nowDate = DateUtil.getNowDate();
        Date date = DateUtil.SchangeD(nowDate);
        if(all.size() > 0) {
            //先筛选除所有的当天订单
            for (DepositWithdrawal d : all) {
                Date outtime = d.getDepositWithdrawaouttime();
                boolean sameDate = DateUtil.isSameDate(outtime, date);
                if (sameDate) {
                    changeList.put(d.getDepositWithdrawalid(), d);
                    continue;
                }
            }
            //再进行操作
            Set<Integer> integers = changeList.keySet();
            for (Integer i : integers) {
                //更新订单状态
                depositWithdrawalDao.updateByID(i);
                //从集合种得到对应订单对象
                DepositWithdrawal de = changeList.get(i);
                //从用户存款种扣钱
                Integer il = de.getDepositWithdrawalmoney();
                depositInformDao.withdrawal(de.getDepositWithdrawalorderid(), il);
                //得到订单信息
                DepositInform depositInform = depositInformDao.selMoney(de.getDepositWithdrawalorderid());
                //得到业务信息
                DepositBusiness business = depositBusinessdao.queryById(depositInform.getDepositInformtype());
                //得到存入时间
                Date depositInformtime = depositInform.getDepositInformtime();
                //算出存入天数
                long daySub = DateUtil.getDaySub(DateUtil.DchangeS(depositInformtime), nowDate);
                //将结果存入Qukuan对象
                Qukuan qukuan = new Qukuan();
                qukuan.setBusinessName(business.getDepositBusinessname());
                double v = Double.parseDouble(business.getDepositBusinessrate());
                qukuan.setBusinessRate(v);
                qukuan.setCardid(depositInform.getDepositInformcardid());
                double mon = (il + ((il * v * 0.01) * daySub) / 365);
                DecimalFormat df = new DecimalFormat(".00");
                double x = Double.parseDouble(df.format(mon));
                qukuan.setMoney(x);
                returnQk.add(qukuan);
            }
            rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_WITHDRAWAL,JSON.toJSONString(returnQk));
        }
    }

    /**
     * 获得客户所有预约接口
     * @param userid
     * @return
     */
    @Override
    public String getwithdrawal(String userid) {
        try {
            int i = Integer.parseInt(userid);
            return  JSON.toJSONString(depositWithdrawalDao.getByUserId(i));
        }catch (Exception e){
            return "400"; //转换错误
        }

    }

    /**
     * 取消预约报错
     * @param userid
     * @return
     */
    @Override
    public String cancelSubscribe(String userid) {
        try{
            int i = Integer.parseInt(userid);
            return JSON.toJSONString(depositWithdrawalDao.deleteById(i));
        }catch (Exception e){
            return "400"; //转换错误
        }
    }
}