package com.cloud.jsproduceraccount.controller;

import com.cloud.jsproduceraccount.Voice.VoiceCode;
import com.cloud.jsproduceraccount.entity.Appointment;
import com.cloud.jsproduceraccount.service.AppointmentService;
import com.cloud.jsproduceraccount.service.pojovalue.Selectone;
import com.cloud.jsproduceraccount.uitl.RedisUtil;
import org.springframework.web.bind.annotation.*;

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
     * @param
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/selectOneApp",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String selectOne(@RequestBody Selectone selectone) {
        System.out.println("getUserId"+selectone.getUserId());
        return this.appointmentService.queryById(selectone.getUserId(),selectone.getTimeone(),selectone.getTimetwo(),selectone.getIndex(),selectone.getPageSize());

    }

    /**
     * 根据预约信息ID和用户ID查询详细信息
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/selectdetails",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String selectdetails(@RequestParam("sel") String sel){
        String[] split = sel.split(",");
        return this.appointmentService.sellAll(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
    }
    /**
     * 添加预约信息       消费者从网关redis那里得到电话传进来
     * @param appointment
     * @return
     */
    /*@RequestMapping(value = "insertOne",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public ModelAndView insertOne(Appointment appointment){
        System.out.println("controller");
        ModelAndView mav = new ModelAndView();
        mav.addObject("insert",appointmentService.insert(appointment));
        mav.setViewName("返回跳转页面");
        return mav;
    }*/

    @RequestMapping(value = "/insertOne",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String insertOne(@RequestBody Appointment appointment){
        System.out.println("controller");
        return appointmentService.insert(appointment);
    }

    /**
     * 修改预约信息状态   撤销  截取字符串 数组  预约信息ID 和userID
     * @param appIduserid
     * @return
     */
    @RequestMapping(value = "/updatastate",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public int updata(@RequestParam("appIduserid") String appIduserid){
        String[] split = appIduserid.split(",");
        System.out.println("appIduserid +++ " + appIduserid);
        return appointmentService.update(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
    }


    ///****************************
    String a = new Random().nextInt(1000000)+"";
    @RequestMapping(value = "/aa",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String aa(){
        VoiceCode.execute("0");
        System.out.println(redisUtil);
        redisUtil.hset("aa","ss",a,1000*60*5);
        System.out.println(redisUtil.hget("aa","ss"));
        return "aa";
    }
}