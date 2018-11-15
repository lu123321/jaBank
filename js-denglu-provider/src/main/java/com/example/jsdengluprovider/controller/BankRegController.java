package com.example.jsdengluprovider.controller;

import com.alibaba.fastjson.JSON;
import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.pojo.BankUser;
import com.example.jsdengluprovider.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRegController {
    @Autowired
    private RegisterService rs;

    @RequestMapping(value = "zhuce",method = RequestMethod.POST)
    public String bankuser(BankUser bankuser,BankCard bankcard){
        String s = rs.addBankuser(bankuser, bankcard);

        return JSON.toJSONString(s);
    }
}
