package com.example.jsdengluprovider.controller;

import com.example.jsdengluprovider.service.UserMassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserMassageController {
    @Autowired
    private UserMassageService ums;
    //通过用户ID找到该用户的身份证信息
    @RequestMapping(value = "selectIdcard",method = RequestMethod.POST)
    public String selectIdcard(@RequestParam("userid")Integer userid){
        return ums.selectIdcard(userid);
    }
}
