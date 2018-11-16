package com.cloud.jsconsumeraccount.feign.feiginImpl;

import com.cloud.jsconsumeraccount.entity.Appointment;
import com.cloud.jsconsumeraccount.feign.AppointmentFeign;
import com.cloud.jsconsumeraccount.pojovalue.Selectdetails;
import com.cloud.jsconsumeraccount.pojovalue.Selectone;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class AppointmentFeignImplHy implements AppointmentFeign {

    @Override
    public String aa() {
        return "错误aa";
    }

    @Override
    public String selectOne(@RequestBody Selectone selectone) {
        return "selectOne错误";
    }

    @Override
    public String selectdetails(@RequestBody Selectdetails selectdetails) {
        return "selectdetails错误";
    }

    @Override
    public String insertOne(@RequestBody Appointment appointment) {
        return "insertOne错误";
    }

    @Override
    public int updata(@RequestParam("appId") Integer appId) {
        return 111111111;
    }
}
