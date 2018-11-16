package com.cloud.jsconsumeraccount.Appointmentservice;

import com.cloud.jsconsumeraccount.entity.Appointment;
import com.cloud.jsconsumeraccount.pojovalue.Selectdetails;
import com.cloud.jsconsumeraccount.pojovalue.Selectone;
import org.springframework.web.bind.annotation.RequestBody;

public interface AppointmentService {

    //根据UserId和时间段查询预约数据集合
    String selectOne(Selectone selectone);
    //根据预约信息ID和用户ID查询详细信息
    String selectdetails(@RequestBody Selectdetails selectdetails);
    //添加预约信息       消费者从网关redis那里得到电话传进来            需要返回ModelAndView
    String insertOne(@RequestBody Appointment appointment);
    //修改预约信息状态   撤销
    String updata(Integer appId);
}
