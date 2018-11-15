package com.example.jsdengluprovider.controller;

import com.example.jsdengluprovider.service.BankUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BankUserConller {
    @Resource
    private BankUserService bankUserService;
    @RequestMapping(value = "userSelect",method = RequestMethod.POST)
    public String userSelect(@RequestParam("userid") Integer userid){
        return bankUserService.userSelect(userid);
    }
}
