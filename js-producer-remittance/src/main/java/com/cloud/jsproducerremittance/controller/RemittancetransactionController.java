package com.cloud.jsproducerremittance.controller;

import com.cloud.jsproducerremittance.entity.Remittancetransaction;
import com.cloud.jsproducerremittance.service.RemittancetransactionService;
import com.cloud.jsproducerremittance.service.valuepojo.Remittanvalue;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Remittancetransaction)表控制层
 *
 * @author makejava
 * @since 2018-11-10 08:51:23
 */
@RestController
public class RemittancetransactionController {
    /**
     * 服务对象
     */
    @Resource
    private RemittancetransactionService remittancetransactionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Remittancetransaction selectOne(Integer id) {
        return this.remittancetransactionService.queryById(id);
    }

    /**
     * 添加汇款信息
     * @param remittancetransaction
     * @return
     */
    @RequestMapping(value = "/insertremittan",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String insertremittan(Remittancetransaction remittancetransaction){
        return remittancetransactionService.insert(remittancetransaction);
    }

    /**
     * 验证码通过开始汇款操作
     * @param remittanvalue
     * @return
     */
    @RequestMapping(value = "/SMSinsertremittan",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String SMSinsertremittan(@RequestBody Remittanvalue remittanvalue) {
        return remittancetransactionService.SMSMQ(remittanvalue);
    }
}