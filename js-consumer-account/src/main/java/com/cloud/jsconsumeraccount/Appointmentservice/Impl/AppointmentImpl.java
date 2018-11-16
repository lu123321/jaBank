package com.cloud.jsconsumeraccount.Appointmentservice.Impl;

import com.cloud.jsconsumeraccount.Appointmentservice.AppointmentService;
import com.cloud.jsconsumeraccount.entity.Appointment;
import com.cloud.jsconsumeraccount.feign.AppointmentFeign;
import com.cloud.jsconsumeraccount.pojovalue.Selectdetails;
import com.cloud.jsconsumeraccount.pojovalue.Selectone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentImpl implements AppointmentService {

    @Autowired
    private AppointmentFeign appointmentFeign;
    /**
     * 根据UserId和时间段查询预约数据集合
     * @param
     * @param
     * @param
     * @param
     * @param
     * @return
     */
    @Override
    public String selectOne(Selectone selectone) {
        String s = appointmentFeign.selectOne(selectone);
        return s;
    }

    @Override
    public String selectdetails(Selectdetails selectdetails) {

        return appointmentFeign.selectdetails(selectdetails);
    }

    @Override
    public String insertOne(Appointment appointment) {
        return appointmentFeign.insertOne(appointment);

    }

    @Override
    public String updata(Integer appId) {
        int updata = appointmentFeign.updata(appId);
        System.out.println("updata +++"+updata);
        if (updata > 0){
            return "撤销成功!";
        }
        return "撤销失败!";
    }
}
