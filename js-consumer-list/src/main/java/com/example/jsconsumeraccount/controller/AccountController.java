package com.example.jsconsumeraccount.controller;

import com.example.jsconsumeraccount.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class AccountController {
    //提供前台两个显示卡信息接口，其他直接跳转至王杰与孙毅页面。
    @Resource
   private AccountService as;


    @RequestMapping(value = "dantiao",method = RequestMethod.POST)
    public String selectOne(@RequestParam("id") Integer id) {
        return as.selectOne(id);
    }

    /**
     * 根据卡关联用户查询用户所有卡片
     * @param id
     * @return
     */
    @RequestMapping(value = "cardid",method = RequestMethod.POST)
    public String liss(@RequestParam("id") Integer id){
        String liss = as.liss(id);
        return liss;
    }

/*
    *//**
     * 消费信息记录 查询
     *
     * @param id 主键
     * @return 单条数据
     *//*
    @RequestMapping(value = "consume",method = RequestMethod.POST)
    public String comsumeid(@RequestParam("id") Integer id) {
        String s = as.comsumeid(id);
        return s;
    }*/

}
