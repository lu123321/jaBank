package com.example.js_deposit_provider.controller;

import com.example.js_deposit_provider.entity.DepositFixation;
import com.example.js_deposit_provider.service.DepositFixationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DepositFixation)表控制层
 *
 * @author makejava
 * @since 2018-11-08 10:32:29
 */
@RestController
public class DepositFixationController {
    /**
     * 服务对象
     */
    @Resource
    private DepositFixationService depositFixationService;

//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("selectOne")
//    public DepositFixation selectOne(Integer id) {
//        return this.depositFixationService.queryById(id);
//    }

    /**
     * 添加订单信息
     * @param depositFixation
     * @return
     */
    @RequestMapping(value = "fixaddInform",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public String addInform(DepositFixation depositFixation){
        return  depositFixationService.insert(depositFixation);
    }

    /**
     * 根据id查询用户定期存款信息
     * @param id
     * @return
     */
    @RequestMapping(value = "getfixInformById",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public String getInformById(@RequestParam("id") String id){
        return  depositFixationService.getAllById(id);
    }

    /**
     * 普通取款
     * @param informId
     * @param money
     * @return
     */
    @RequestMapping(value = "commonfixQK",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
    public String commonQK(String informId,String money){
        return depositFixationService.getmoney(informId,money);
    }
}