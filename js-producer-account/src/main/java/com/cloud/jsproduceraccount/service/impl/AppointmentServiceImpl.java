package com.cloud.jsproduceraccount.service.impl;

import com.alibaba.fastjson.JSON;
import com.cloud.jsproduceraccount.dao.BranchDao;
import com.cloud.jsproduceraccount.dao.CurrencytableDao;
import com.cloud.jsproduceraccount.entity.Appointment;
import com.cloud.jsproduceraccount.dao.AppointmentDao;
import com.cloud.jsproduceraccount.entity.Branch;
import com.cloud.jsproduceraccount.service.AppointmentService;
import com.cloud.jsproduceraccount.service.pojo.AppointmentServicepojo;
import com.cloud.jsproduceraccount.service.pojo.Appointmentparticulars;
import com.cloud.jsproduceraccount.uitl.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * (Appointment)表服务实现类
 *
 * @author makejava
 * @since 2018-11-10 08:49:50
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Resource
    private AppointmentDao appointmentDao;
    @Resource
    private BranchDao branchDao;
    @Resource
    private CurrencytableDao currencytableDao;
    @Resource
    private RedisUtil redisUtil;
    /**
     * 通过账户ID查询预约信息数据
     *
     * @param UserId 主键
     * @return 实例对象
     */
    @Override
    public String queryById(Integer UserId,String timeone,String tiometwo,Integer index,Integer pageSize) {

        List<Appointment> appointments = this.appointmentDao.queryById(UserId, timeone, tiometwo);
        List<AppointmentServicepojo> list = new ArrayList<AppointmentServicepojo>();

        for (Appointment appointment:appointments) {
            AppointmentServicepojo appointmentServicepojo = new AppointmentServicepojo();
            //用户ID
            appointmentServicepojo.setAppointmentUserid(appointment.getAppointmentUserid());
            //预约ID
            appointmentServicepojo.setAppointmentId(appointment.getAppointmentId());
            //预约编号
            appointmentServicepojo.setAppointmentNumber(appointment.getAppointmentNumber());
            //预约业务种类
            appointmentServicepojo.setAppointmentBusinesstype(appointment.getAppointmentBusinesstype() == 1?"人名币大额现金取款":"外币现金取款");
            //预约提交日期
            appointmentServicepojo.setAppointmentCurrentdata(appointment.getAppointmentCurrentdata());
            //预约办理日期
            appointmentServicepojo.setAppointmentData(appointment.getAppointmentData());
            //预约办理时间
            appointmentServicepojo.setAppointmentTime(appointment.getAppointmentTime());
            //预约办理网点
            appointmentServicepojo.setAppointmentBranch(branchDao.querybyid(appointment.getAppointmentBranch()).getBranchName());
            //预约办理渠道
            appointmentServicepojo.setAppointmentChannel(appointment.getAppointmentChannel() == 1?"个人网银":"未知");
            //预约执行结果
            switch (appointment.getAppointmentResult()){
                case 1:
                    appointmentServicepojo.setAppointmentResult("待银行审批");
                    break;
                case 2:
                    appointmentServicepojo.setAppointmentResult("已撤销");
                    break;
                case 3:
                    appointmentServicepojo.setAppointmentResult("预约失败");
                    break;
                case 4:
                    appointmentServicepojo.setAppointmentResult("已完成");
                    break;
            }
            list.add(appointmentServicepojo);
        }

        PageHelper.startPage(index,pageSize);
        PageInfo<AppointmentServicepojo> p = new PageInfo<>(list);
//        PageInfo p = new PageInfo(list);

        return JSON.toJSONString(p);
    }

    /**
     *根据预约信息ID和用户ID查询详细信息
     * @param appId
     * @param Userid
     * @return
     */
    public String sellAll(Integer appId, Integer Userid){

        Appointment appointment = this.appointmentDao.selAll(appId, Userid);
        Integer appointmentResult = appointment.getAppointmentResult();
        System.out.println(appointmentResult);
        Appointmentparticulars App = new Appointmentparticulars();
        //预约编号
        App.setAppointmentNumber(appointment.getAppointmentNumber());
        //预约业务种类1:人名币大额现金取款 2:外币现金取款
        App.setAppointmentBusinesstype(appointment.getAppointmentBusinesstype()==1?"人名币大额现金取款":"外币现金取款");
        //币种
        App.setAppointmentCurrency(currencytableDao.queryById(appointment.getAppointmentCurrency()).getCurrencytableName());
        //预约取款金额
        App.setAppointmentPrice(appointment.getAppointmentPrice());
        //预约办理网点
        App.setAppointmentBranch(branchDao.querybyid(appointment.getAppointmentBranch()).getBranchName());
        //手机号
        App.setAppointmentPhone(appointment.getAppointmentPhone());
        //提交预约日期(年月日)
        App.setAppointmentCurrentdata(appointment.getAppointmentCurrentdata());
        //预约办理渠道
        App.setAppointmentChannel("个人网银");

        if (appointmentResult == 4){
             //预约办理日期(年月日)
            App.setAppointmentData(appointment.getAppointmentData());
            //预约执行结果1: 待银行审批 2:已撤销 3:预约失败 4：已完成
            App.setAppointmentResult("已完成");
            return JSON.toJSONString(App);
        }else {
            //预约处理时间
            App.setAppointmentData("-");
            App.setAppointmentResult("-");
            return JSON.toJSONString(App);
        }
    }

    /**
     * 根据ID修改撤销状态
     * @param appointmentId 实例对象ID
     * @return
     */
    @Override
    public int update(Integer appointmentId) {
        return appointmentDao.update(appointmentId);
    }


    /**
     * 新增数据
     *  添加预约信息
     * @param appointment 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Appointment appointment) {
        System.out.println("service");
        /*boolean b = redisUtil.hasKey(appointment.getAppointmentId() + "");
        if (!b){
            return "401";
        }*/
//        String st = (String) redisUtil.get(appointment.getAppointmentId() + "");

//        if (Token != null && !"".equals(Token) && Token.equals(st) ){
        Date date = new Date();
        StringBuffer sb = new StringBuffer();
        String str = "0123456789";
        Random r = new Random();
        for(int i=0;i<7;i++){
            int num = r.nextInt(str.length());
            sb.append(str.charAt(num));
            str = str.replace((str.charAt(num)+""), "");
        }

        String stro = new SimpleDateFormat("yyyyMM").format(date);
        Long m = Long.parseLong((stro)) * 10000000000000L;
        Long l = Long.parseLong(sb.toString());
        Long ll = m + l;

        appointment.setAppointmentNumber(String.valueOf(ll));//预约编号
        appointment.setAppointmentUserid(1);//预约人ID  前台给
        appointment.setAppointmentCurrency(1);//默认人名币 1 代表人名币
        String data = new SimpleDateFormat("yyyy-MM-dd").format(date);
        appointment.setAppointmentCurrentdata(data);
        appointment.setAppointmentChannel(1);//个人网银
        appointment.setAppointmentResult(1);//预约结果
        System.out.println("金额"+appointment.getAppointmentPrice());
        int insert = this.appointmentDao.insert(appointment);

        if (insert > 0){
            Branch branch = branchDao.queryById(appointment.getAppointmentId());

            return "[{\"200\"\":\""+ String.valueOf(ll) + "\"}" + "," + "{\"200\"\":\""+ branch.getBranchName() + "\"}" + "]";
        }else {
            return "{\"401\":\"预约失败!\"}";
        }
//        }
//        return "401";
    }

    /**
     * 通过主键删除数据
     *
     * @param appointmentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer appointmentId) {
        return this.appointmentDao.deleteById(appointmentId) > 0;
    }
}