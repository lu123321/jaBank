package com.cloud.jsconsumeraccount.feign;

import com.cloud.jsconsumeraccount.entity.Appointment;
import com.cloud.jsconsumeraccount.feign.feiginImpl.AppointmentFeignImplHy;
import com.cloud.jsconsumeraccount.pojovalue.Selectdetails;
import com.cloud.jsconsumeraccount.pojovalue.Selectone;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "js-producer-account",fallback = AppointmentFeignImplHy.class)
public interface AppointmentFeign {

    /*@RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam("count")int count);*/

    @RequestMapping(value = "/aa",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String aa();

    //AppointmentController

    /**
     * 通过UserId和时间段查询预约数据集合
     * @param
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/selectOne",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String selectOne(@RequestBody Selectone selectone);


    /**
     * 根据预约信息ID和用户ID查询详细信息
     * @param
     * @param
     * @return*/

    @RequestMapping(value = "/selectdetails",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String selectdetails(@RequestBody Selectdetails selectdetails);

   /**
     * 添加预约信息       消费者从网关redis那里得到电话传进来            需要返回ModelAndView
     * @param appointment
     * @return*/

    @RequestMapping(value = "/insertOne",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String insertOne(@RequestBody Appointment appointment);

    /**
     * 修改预约信息状态   撤销
     * @param appId
     * @return*/

    @RequestMapping(value = "/updatastate",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public int updata(@RequestParam("appId") Integer appId);
}
