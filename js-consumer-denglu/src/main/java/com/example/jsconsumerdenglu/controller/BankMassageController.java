package com.example.jsconsumerdenglu.controller;

import com.example.jsconsumerdenglu.service.BankMassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BankMassageController {
    @Autowired
    private BankMassageService bankMassageService;

    @RequestMapping(value = "bankMassage",method = RequestMethod.POST)
    public String BankMassageSelect(@RequestParam("userid") Integer userid){
        return bankMassageService.BankMassageSelect(userid);
    }
}
