package com.example.jsconsumeraccount.controller;

import com.example.jsconsumeraccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {

    @Autowired
   private AccountService as;


    @RequestMapping(value = "dantiao",method = RequestMethod.POST)
    public String selectOne(@RequestParam("id") Integer id) {
        return as.selectOne(id);
    }



}
