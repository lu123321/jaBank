package com.cloud.jsproducerremittance.controller;

import com.cloud.jsproducerremittance.entity.Remittancetransaction;
import com.cloud.jsproducerremittance.pojovalue.Remittansel;
import com.cloud.jsproducerremittance.service.RemittancetransactionService;
import com.cloud.jsproducerremittance.pojovalue.Remittanvalue;
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
    public String SMSinsertremittan(Remittanvalue remittanvalue) {
        return remittancetransactionService.SMSMQ(remittanvalue);
    }

    /**
     * 单笔汇款明细查询
     * @param remittansel
     * @return
     */
    @RequestMapping(value = "/Singlerem",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String Singlerem(Remittansel remittansel){
        return remittancetransactionService.selALL(remittansel);
    }

    /**
     * 根据明细ID查询详细信息
     * @param remid
     * @return
     */
    @RequestMapping(value = "/selonerem",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String selonerem(Integer remid){
        return remittancetransactionService.selone(remid);
    }
}