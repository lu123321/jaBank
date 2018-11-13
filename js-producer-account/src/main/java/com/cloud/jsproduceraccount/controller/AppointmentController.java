package com.cloud.jsproduceraccount.controller;

import com.cloud.jsproduceraccount.Voice.VoiceCode;
import com.cloud.jsproduceraccount.entity.Appointment;
import com.cloud.jsproduceraccount.service.AppointmentService;
import com.cloud.jsproduceraccount.uitl.RedisUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Random;

/**
 * (Appointment)表控制层
 *
 * @author makejava
 * @since 2018-11-10 08:49:50
 */
@RestController
public class AppointmentController {
    /**
     * 服务对象
     */
    @Resource
    private AppointmentService appointmentService;
    @Resource
    private RedisUtil redisUtil;

    /**
     * 通过UserId和时间段查询预约数据集合
     * @param UserId
     * @param timeone
     * @param tiometwo
     * @return
     */
    @RequestMapping(value = "selectOne",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String selectOne(Integer UserId,String timeone, String tiometwo,Integer index,Integer pageSize) {

        return this.appointmentService.queryById(UserId,timeone,tiometwo,index,pageSize);

    }

    /**
     * 根据预约信息ID和用户ID查询详细信息
     * @param appId
     * @param Userid
     * @return
     */
    @RequestMapping(value = "selectdetails",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String selectdetails(Integer appId,Integer Userid){
        return this.appointmentService.sellAll(appId,Userid);
    }
    /**
     * 添加预约信息
     * @param appointment
     * @return
     */
    @RequestMapping(value = "insertOne",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public ModelAndView insertOne(@RequestBody Appointment appointment){
        System.out.println("controller");
        ModelAndView mav = new ModelAndView();
        mav.addObject("insert",appointmentService.insert(appointment));
        mav.setViewName("返回跳转页面");
        return mav;
    }

    /**
     * 修改预约信息状态   撤销
     * @param appId
     * @return
     */
    @RequestMapping(value = "updatastate",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public int updata(Integer appId){
        return appointmentService.update(appId);
    }
    String a = new Random().nextInt(1000000)+"";
    @RequestMapping("/aa")
    public String aa(){
        VoiceCode.execute("0");
        System.out.println(redisUtil);
        redisUtil.hset("aa","ss",a,1000*60*5);
        System.out.println(redisUtil.hget("aa","ss"));
        return "aa";
    }
}