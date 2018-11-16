package com.cloud.jsconsumeraccount.Appointmentservice.Impl;

import com.cloud.jsconsumeraccount.feign.AppointmentFeign;
import com.cloud.jsconsumeraccount.Appointmentservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AppointmentFeign appointmentFeign;

    @Override
    public String aa() {
        return appointmentFeign.aa();
    }



    /*@Override
    public String login(int count) {
        return userFeign.login(count);
    }*/

   /* @Override
    public String login() {

        return userFeign.login();
    }*/
}
