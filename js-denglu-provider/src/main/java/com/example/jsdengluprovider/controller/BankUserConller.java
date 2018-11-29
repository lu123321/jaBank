package com.example.jsdengluprovider.controller;

import com.example.jsdengluprovider.service.BankUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class BankUserConller {
    @Resource
    private BankUserService bankUserService;
    @RequestMapping(value = "userSelect",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String userSelect(@RequestParam("userid") Integer userid){
        return bankUserService.userSelect(userid);
    }

    /**
     * 通过用户id查看用户预留的信息
     * @param userid
     * @return
     */
    @RequestMapping(value = "getphone",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public  String getphone(@RequestParam("userid") String userid){
        return  bankUserService.getphone(userid);
    }
}

