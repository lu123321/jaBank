package com.example.jsconsumeroptions.controller;

import com.example.jsconsumeroptions.pojo.Appointment;
import com.example.jsconsumeroptions.pojo.BankCard;
import com.example.jsconsumeroptions.service.InvokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvokeController {

    @Autowired
    private InvokeService is;

    @RequestMapping(value = "insertOne",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String insertOne(Appointment appointment){
        return is.insertOne(appointment);
    }


    /**
     * 获取登录后个人所有信息
     * @param userid
     * @return
     */
    @RequestMapping(value = "bankCard",method = RequestMethod.POST)
    public List<BankCard> banCard(@RequestParam("userid") Integer userid){
        List<BankCard> list = is.banCard(userid);
        return list;
    }


}
