package com.example.jsconsumeroptions.service.impl;

import com.example.jsconsumeroptions.pojo.Appointment;
import com.example.jsconsumeroptions.pojo.BankCard;
import com.example.jsconsumeroptions.service.InvokeService;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public List<BankCard> banCard(Integer userid) {
        return null;
    }
}