package com.example.jsconsumeraccount.controller;

import com.example.jsconsumeraccount.service.CreditService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CreditController {

    @Resource
    private CreditService cs;

    /**
     * 消费信息记录 查询
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "consume",method = RequestMethod.POST)
    public String comsumeid(@RequestParam("id") Integer id) {
        String s = cs.comsumeid(id);
        return s;
    }
}
