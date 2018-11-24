package com.example.jsproducerloans.controller;

import com.example.jsproducerloans.entity.LoansIndent;
import com.example.jsproducerloans.service.LoansIndentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (LoansIndent)表控制层
 *
 * @author makejava
 * @since 2018-11-17 17:23:50
 */
@RestController
public class LoansIndentController {
    /**
     * 服务对象
     */
    @Resource
    private LoansIndentService loansIndentService;
    /**
     * 生成贷款订单接口
     * @param loansIndent
     * @param name
     * @param value
     * @return
     */
    @RequestMapping(value = "addInform",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    public String addInform(LoansIndent loansIndent,@RequestParam String[] name,@RequestParam String[] value) {
       return loansIndentService.insert(loansIndent,name,value);
    }

    /**
     * 查看用户的所有的贷款信息
     * @param userid
     * @return
     */
    @RequestMapping(value = "getloanInform",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    public String getInform(@RequestParam String userid){
        return loansIndentService.getInformByUserId(userid);
    }

    /**
     * 根据订单id修改订单状态
     * @param informid
     * @return
     */
    @RequestMapping(value = "changeinformstate",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    public String changeinformstate(String informid){
        return  loansIndentService.changeByinformid(informid);
    }

    /**
     * 查看贷款订单id逾期记录
     * @param informid
     * @return
     */
    @RequestMapping(value = "overdue",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    public String overdue(String informid){
       return loansIndentService.overduelist(informid);
    }

    /**
     * 根据传入的逾期期数及金额进行逾期还款
     * @param planid
     * @return
     */
    @RequestMapping(value = "returnover",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    public String returnover(String planid,String money){
        return loansIndentService.returnover(planid,money);
    }

    /**
     * 一次性还款时根据id查看应还金额
     * @param informid
     * @return
     */
    @RequestMapping(value = "oneReturn",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    public String oneReturn(String informid){
        return  loansIndentService.residBenjin(informid);
    }

    /**
     * 根据订单id修改所有贷款状态
     * @param informid
     * @return
     */
    @RequestMapping(value = "changestate",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    public String changestate(String informid){
        return loansIndentService.informquchu(informid);
    }
}