package com.example.jsconsumeroptions.controller;

import com.alibaba.fastjson.JSON;
import com.example.jsconsumeroptions.pojo.Appointment;
import com.example.jsconsumeroptions.service.InvokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvokeController {

    @Autowired
    private InvokeService is;

    @RequestMapping(value = "insertOne",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String insertOne(Appointment appointment){
        return is.insertOne(appointment);
    }
}
