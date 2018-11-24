package com.example.jsproducerloans.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducerloans.dao.LoansPayDao;
import com.example.jsproducerloans.dao.LoansPlanDao;
import com.example.jsproducerloans.dao.LoansTypeDao;
import com.example.jsproducerloans.entity.LoansIndent;
import com.example.jsproducerloans.dao.LoansIndentDao;
import com.example.jsproducerloans.entity.LoansPay;
import com.example.jsproducerloans.entity.LoansPlan;
import com.example.jsproducerloans.entity.LoansType;
import com.example.jsproducerloans.service.LoansIndentService;
import com.example.jsproducerloans.service.pojo.DaiKuai;
import com.example.jsproducerloans.service.pojo.GetYue;
import com.example.jsproducerloans.service.pojo.Qukuan;
import com.example.jsproducerloans.util.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * (LoansIndent)表服务实现类
 *
 * @author makejava
 * @since 2018-11-17 17:23:50
 */
@Service
public class LoansIndentServiceImpl implements LoansIndentService {
    @Resource
    private LoansIndentDao loansIndentDao;
    @Resource
    private LoansTypeDao loansTypeDao;
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Resource
    private LoansPlanDao loansPlanDao;
    @Resource
    private  LoansPayDao loansPayDao;
    /**
     * 通过ID查询单条数据
     * @param loansIndentid 主键
     * @return 实例对象
     */
    @Override
    public LoansIndent queryById(Integer loansIndentid) {
        return this.loansIndentDao.queryById(loansIndentid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<LoansIndent> queryAllByLimit(int offset, int limit) {
        return this.loansIndentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param loansIndent 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(LoansIndent loansIndent,String[] name,String[] value) {
        Integer loansUserid = loansIndent.getLoansUserid();
        if(loansUserid != null){
            String s = ExcleUtil.creatExcel(loansUserid.toString(), name, value);
            loansIndent.setLoansContract(s);
            loansIndent.setLoansIndentnumber(OrderNumberUtil.createNumber(loansUserid.toString()));
            loansIndent.setLoansState(0);
            Integer loansType = loansIndent.getLoansType();
            int i = loansIndent.getLoansLong();
            LoansType loansType1 = loansTypeDao.queryById(loansType);
            if(i<6){
                loansIndent.setLoanslixi(loansType1.getLoanRatesixmon());
            }else  if(i<12){
                loansIndent.setLoanslixi(loansType1.getLoanRateoneyear());
            }else if(i<36){
                loansIndent.setLoanslixi(loansType1.getLoanRatethree());
            }else if(i<60){
                loansIndent.setLoanslixi(loansType1.getLoanRatefive());
            }else{
                loansIndent.setLoanslixi(loansType1.getLoanRatemore());
            }
            loansIndentDao.insert(loansIndent);
            return "申请成功";
        }else {
            return "请求错误";
        }
    }

    /**
     * 修改数据
     *
     * @param loansIndent 实例对象
     * @return 实例对象
     */
    @Override
    public String update(LoansIndent loansIndent) {
        this.loansIndentDao.update(loansIndent);
        this.queryById(loansIndent.getLoansIndentid());
        return null;
    }

    /**
     * 通过主键删除数据
     * @param loansIndentid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer loansIndentid) {
        return this.loansIndentDao.deleteById(loansIndentid) > 0;
    }

    /**
     * 根据用户id查看用户信息
     * @param userid
     * @return
     */
    @Override
    public String getInformByUserId(String userid) {
        if(userid != null && userid != ""){
            List<LoansIndent> allUserId = loansIndentDao.getAllUserId(Integer.parseInt(userid));
            return JSON.toJSONString(allUserId);
        }else {
            return "400";
        }
    }

    /**
     * 根据订单id进行订单状态修改及进行一系列操作
     * @param informid
     * @return
     */
    @Override
    public String changeByinformid(String informid) {
        List<Qukuan> qlist = new ArrayList<Qukuan>();
        if(informid != null && informid != ""){
            //修改订单状态
            loansIndentDao.updatestate(Integer.parseInt(informid));
            //查到订单相关信息
            LoansIndent loansIndent = loansIndentDao.queryById(Integer.parseInt(informid));
            Qukuan q = new Qukuan();
            if(loansIndent.getLoansType() == 0){
                q.setBusinessName("个人住房贷款");
            }else{
                q.setBusinessName("质押贷款");
            }
            q.setCardid(loansIndent.getLoanscard());
            q.setMoney(loansIndent.getLoansMoney());
            q.setState(2);
            qlist.add(q);
            //将金额和卡号放入队列，供银行卡那边加金额
            rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_WITHDRAWAL,JSON.toJSONString(qlist));
            //订单生成后需要在还款表中生成对应的还款信息
            Integer loansRefund = loansIndent.getLoansRefund();
            int a = loansRefund;
            //判断还款方式：1为等额本息 2为等额本金
            //获得贷款金额
            Double loansMoney = loansIndent.getLoansMoney();
            //获得贷款时长
            Integer loansLong = loansIndent.getLoansLong();
            //获得贷款利率
            Double loanslixi = loansIndent.getLoanslixi();
            System.out.println(loanslixi);
            System.out.println(loansMoney);
            System.out.println(loansLong);
            //等额本息还款计算
            if(a == 1){
                //计算每期需要还多少利息
                BigDecimal perMonthPrincipalInterest = AverageCapitalPlusInterestUtils.getPerMonthPrincipalInterest(loansMoney, loanslixi, loansLong);
                //计算每期需要还多少本金
                Map<Integer, BigDecimal> perMonthPrincipal = AverageCapitalPlusInterestUtils.getPerMonthPrincipal(loansMoney, loanslixi, loansLong);
                //计算每期需要还多少本金加利息
                Map<Integer, BigDecimal> perMonthInterest = AverageCapitalPlusInterestUtils.getPerMonthInterest(loansMoney, loanslixi, loansLong);
                String nowDate = DateUtil.getNowDate();
                Date date = DateUtil.SchangeD(nowDate);
                for (int i = 0;i<loansLong;i++){
                    LoansPlan plan = new LoansPlan();
                    System.out.println(perMonthPrincipal.get(i));
                    plan.setLoansPlanmoney(perMonthPrincipalInterest.doubleValue());
                    plan.setLoansBenjin(perMonthPrincipal.get(i).doubleValue());
                    plan.setLoansPlanlixi(perMonthInterest.get(i).doubleValue());
                    plan.setLoansPlaninformid(loansIndent.getLoansIndentid());
                    plan.setLoansState(0);
                    plan.setLoansPlantime(DateUtil.getfuture(date,i+1));
                    loansPlanDao.insert(plan);
                }
            } else {
                //计算每期需要还多少利息和本金
                Map<Integer, Double> perMonthPrincipalInterest = AverageCapitalUtils.getPerMonthPrincipalInterest(loansMoney, loanslixi, loansLong);
                //计算每期需要还多少利息
                Map<Integer, Double> perMonthInterest = AverageCapitalUtils.getPerMonthInterest(loansMoney, loanslixi, loansLong);
                //计算每期需要的本金
                double perMonthPrincipal = AverageCapitalUtils.getPerMonthPrincipal(loansMoney, loansLong);
                String nowDate = DateUtil.getMonth() + "-09";
                Date date = DateUtil.SchangeD(nowDate);
                for (int i = 0;i<loansLong;i++){
                    LoansPlan plan = new LoansPlan();
                    plan.setLoansPlanmoney(perMonthPrincipalInterest.get(i).doubleValue());
                    plan.setLoansBenjin(perMonthPrincipal);
                    plan.setLoansPlanlixi(perMonthInterest.get(i).doubleValue());
                    plan.setLoansPlaninformid(loansIndent.getLoansIndentid());
                    plan.setLoansState(0);
                    plan.setLoansPlantime(DateUtil.getfuture(date,i+1));
                    loansPlanDao.insert(plan);
                }
            }
            return "200";
        }else{
            return "400";
        }
    }

    /**
     * 根据贷款订单查看该订单逾期信息
     * @param informid
     * @return
     */
    @Override
    public String overduelist(String informid) {
        if(informid != null && informid != ""){
            List<LoansPlan> userover = loansPlanDao.getUserover(Integer.parseInt(informid));
            if(userover.size() > 0){
                List<LoansPlan> returnover = new ArrayList<LoansPlan>();
                for (LoansPlan l : userover){
                    Integer loansPlaninformid = l.getLoansPlaninformid();
                    //得到订单原利率
                    Double aDouble = loansIndentDao.selLixi(Integer.parseInt(informid));
                    //得到逾期本金
                    Double loansBenjin1 = l.getLoansBenjin();
                    //得到原还款日期
                    Date loansPlantime = l.getLoansPlantime();
                    //得到逾期的天数
                    String nowDate = DateUtil.getNowDate();
                    long daySub = DateUtil.getDaySub(nowDate, DateUtil.DchangeS(loansPlantime));
                    //逾期利息
                    Double a = loansBenjin1*(aDouble*(1+0.3))*daySub;
                    Double all = l.getLoansPlanmoney() + a;
                    DecimalFormat df = new DecimalFormat(".00");
                    double v = Double.parseDouble(df.format(all));
                    //需要还多少钱
                    l.setLoansYuqiMoney(v);
                    l.setLoansOverlong((int) daySub);
                    returnover.add(l);
                }
                return JSON.toJSONString(returnover);
            }else{
                return "无逾期信息";
            }

        }else {
            return "400";
        }
    }

    /**
     * 根据传入逾期期数和金额进行逾期处理
     * @param planid
     * @param money
     * @return
     */
    @Override
    public String returnover(String planid, String money) {
        if(planid != null && planid != "" && money != null && money != ""){
            LoansPlan loansPlan = loansPlanDao.queryById(Integer.parseInt(planid));
            Double aDouble = loansIndentDao.selLixi(loansPlan.getLoansPlaninformid());
            DecimalFormat df = new DecimalFormat(".00");
            //得到逾期本金
            Double loansBenjin1 = loansPlan.getLoansBenjin();
            System.out.println(loansBenjin1);
            //得到原还款日期
            Date loansPlantime = loansPlan.getLoansPlantime();
            //得到逾期的天数
            String nowDate = DateUtil.getNowDate();
            long daySub = DateUtil.getDaySub(nowDate, DateUtil.DchangeS(loansPlantime));
            //逾期利息
            Double a = loansBenjin1*(aDouble*(1+0.3))*daySub;
            Double a1 = Double.parseDouble(df.format(a));
            System.out.println(a1);
            //需要还的金额
            double needpay = loansPlan.getLoansPlanmoney() + a1;

            double v = Double.parseDouble(df.format(needpay));
            System.out.println(v);
            if(Double.parseDouble(money) == v){
                LoansPlan loansPlan1 = new LoansPlan();
                loansPlan1.setLoansPlanid(Integer.parseInt(planid));
                loansPlan1.setLoansOverlong((int) daySub);
                //状态为2为已还款
                loansPlan1.setLoansState(2);
                int update = loansPlanDao.update(loansPlan1);
                if(update > 0){
                    Integer updatemoney = loansPayDao.updatemoney(loansBenjin1,a1, loansPlan.getLoansPlaninformid());
                    System.out.println(updatemoney);
                    if(updatemoney == 0){
                        LoansPay pay = new LoansPay();
                        pay.setLoansLixi(a);
                        pay.setLoansRegbenjin(loansBenjin1);
                        pay.setLoansIndentid(loansPlan.getLoansPlaninformid());
                        loansPayDao.insert(pay);
                    }
                    return "还款成功";
                }else{
                    return "400";
                }

            }else{
                return "操作出错";
            }
        }else{
            return "400";
        }
    }

    /**
     * 根据订单id查看用户一次性还款需要还多少钱
     * @param informid
     * @return
     */
    @Override
    public String residBenjin(String informid) {
        if(informid != null && informid != ""){
            LoansIndent loansIndent = loansIndentDao.queryById(Integer.parseInt(informid));
            Double aDouble = loansPayDao.queryByInformId(Integer.parseInt(informid));
            DaiKuai q = new DaiKuai();
                Double needpay = aDouble*(1+loansIndent.getLoanslixi());
                String loanscard = loansIndent.getLoanscard();
                q.setState(2);
                q.setBusinessName("个人住房贷款");
                q.setMoney(needpay);
                q.setCardid(loanscard);
                q.setInformid(Integer.parseInt(informid));
                return JSON.toJSONString(q);
        }else{
            return "400";
        }
    }

    /**
     *根据订单id进行状态修改
     * @param informid
     * @return
     */
    public String informquchu(String informid){
        if(informid != null && informid != ""){
            int i = Integer.parseInt(informid);
            loansIndentDao.updatestate1(i);
            loansPlanDao.updateallstate(i);
            loansPayDao.deleteByImform(i);
            return "还款成功";
        }else {
            return "400";
        }
    }
    //定时任务进行还款，每月9号进行查看数据库还款表，
    //查看有没有是本月还款的，此时需要查看卡中余额是否足够，这边定时任务查看需要今天还款的所有订单信息
    //查到后将信息发向银行卡那边查看余额是否足够，足够的话扣除相应的金额，将处理好的订单信息传入己方这边进行后续操作
    //如果有则进行还款，修改还款表的数据状态，并改pay表中的数据
    //如果卡中余额不足则将还款表中数据设为逾期，并填写逾期金额。
   // @Scheduled(cron = "5 * * * * ? ")//0 0 22 9 * ?
    public void getNeedPay(){
        List<GetYue> glist = new ArrayList<GetYue>();
        String nowDate = DateUtil.getNowDate();
        Date date = DateUtil.SchangeD(nowDate);
        List<LoansPlan> needPay = loansPlanDao.getNeedPay(date);
        for (LoansPlan l :needPay){
            GetYue g = new GetYue();
            Integer loansPlaninformid = l.getLoansPlaninformid();
            String s = loansIndentDao.getcardByid(loansPlaninformid);
            g.setCard(s);
            g.setMoney(l.getLoansPlanmoney());
            g.setPlanid(l.getLoansPlanid());
            glist.add(g);
        }
        //此处查出所有需要还款的卡信息，到银行卡服务查看所有的卡余额是否足够够的话进行扣除
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_GETYUE,JSON.toJSONString(glist));
    }

    /**
     * 监控返回队列进行数据操作
     * @param meg
     */
    @RabbitListener(queues = RabbitConfig.QUEUE_YUERETURN)
    public void changePlan(String meg){
        List<GetYue> getYues = JSON.parseArray(meg, GetYue.class);
        for (GetYue g : getYues){
            //判断银行卡服务是否扣钱成功
            if(g.getState() == 0){
                //改状态为1表示还款完成
                loansPlanDao.updatestate(g.getPlanid());
                LoansPlan plan = loansPlanDao.queryById(g.getPlanid());
                Integer updatemoney = loansPayDao.updatemoney(plan.getLoansBenjin(), plan.getLoansPlanlixi(), plan.getLoansPlaninformid());
                if(updatemoney == null){
                    LoansPay pay = new LoansPay();
                    pay.setLoansLixi(plan.getLoansPlanlixi());
                    pay.setLoansRegbenjin(plan.getLoansBenjin());
                    pay.setLoansIndentid(plan.getLoansPlaninformid());
                    loansPayDao.insert(pay);
                }
            }else{
                //如果扣除失败则修改订单状态为逾期，更新逾期金额
                LoansPlan  loansPlan = new LoansPlan();
                loansPlan.setLoansYuqiMoney(g.getMoney());
                loansPlan.setLoansState(2);
                loansPlan.setLoansPlanid(g.getPlanid());
                loansPlanDao.update(loansPlan);
            }
        }
    }


}