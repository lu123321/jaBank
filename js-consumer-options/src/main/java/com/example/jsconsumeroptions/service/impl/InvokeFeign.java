package com.example.jsconsumeroptions.service.impl;

import com.example.jsconsumeroptions.pojo.Appointment;
import com.example.jsconsumeroptions.service.InvokeService;
import org.springframework.stereotype.Component;

@Component
public class InvokeFeign implements InvokeService {
    /**
     * @param appointment
     * @return
     */
    @Override
    public String insertOne(Appointment appointment) {
        return "连接超时";
    }
}