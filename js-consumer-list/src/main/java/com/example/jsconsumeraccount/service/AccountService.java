package com.example.jsconsumeraccount.service;

import com.example.jsconsumeraccount.service.impl.AccountFeign;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "js-producer-creditcard",fallback = AccountFeign.class)
public interface AccountService {

/*    *//**
     * 查询单条数据
     *
     * @param id
     * @return
     *//*
    @RequestMapping(value = "area",method = RequestMethod.POST)
    public String selectOne(@RequestParam("id") Integer id);*/
    @RequestMapping(value = "dantiao", method = RequestMethod.POST)
    public String selectOne(@RequestParam("id") Integer id);


    /**
     * 根据卡关联用户查询用户所有卡片
     * @param id
     * @return
     */
    @RequestMapping(value = "cardid",method = RequestMethod.POST)
    public String liss(@RequestParam("id") Integer id);




}