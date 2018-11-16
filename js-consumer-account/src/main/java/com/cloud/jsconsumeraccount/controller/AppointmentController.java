package com.cloud.jsconsumeraccount.controller;

import com.cloud.jsconsumeraccount.Appointmentservice.AppointmentService;
import com.cloud.jsconsumeraccount.Appointmentservice.UserService;
import com.cloud.jsconsumeraccount.entity.Appointment;
import com.cloud.jsconsumeraccount.pojovalue.Selectdetails;
import com.cloud.jsconsumeraccount.pojovalue.Selectone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {


    /**
     * 注入
     */
    @Autowired
    private UserService userService;
    @Autowired
    private AppointmentService appointmentService;


    @RequestMapping(value = "/Userlogin",method = RequestMethod.POST)
    public String login(){
        System.out.println("访问");
        /*for (int i = 0; i< 10;i++){
            userService.login(i);
        }*/
//        return "666";
        return userService.aa();
    }
    @RequestMapping(value = "/User",method = RequestMethod.POST)
    public String abc(){
        return "访问";
    }

    //*********************************************************************

    /**
     * 根据UserId和时间段查询预约数据集合
     * @param
     * @param
     * @param
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/conselectone",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String selectOne(Selectone selectone){
        System.out.println("getUserId"+ selectone.getUserId());
        System.out.println("appointmentService.selectOne(selectone)"+appointmentService.selectOne(selectone));
        return appointmentService.selectOne(selectone);
    }
    @RequestMapping(value = "/conselectdetails",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String Selectdetails(Selectdetails selectdetails){
         return appointmentService.selectdetails(selectdetails);
    }
    @RequestMapping(value = "/coninsertOne",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String insertOne(Appointment appointment){
        return appointmentService.insertOne(appointment);
    }
    @RequestMapping(value = "/conupdatastate",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String updata(Integer appId){
        return appointmentService.updata(appId);
    }
}


