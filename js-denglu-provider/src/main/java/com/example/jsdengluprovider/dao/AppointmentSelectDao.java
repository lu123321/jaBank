package com.example.jsdengluprovider.dao;


import com.example.jsdengluprovider.pojo.Appointment;
import org.springframework.stereotype.Component;

//预约查询
@Component
public interface AppointmentSelectDao {
    //个人预约信息查询
    Appointment appoinSelect();
    //添加个人预约信息
    int insertApp(Appointment appointment);
    //删除个人预约信息
    int deletApp(Appointment appointment);
}
