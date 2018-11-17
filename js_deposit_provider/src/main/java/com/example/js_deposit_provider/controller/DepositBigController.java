package com.example.js_deposit_provider.controller;

import com.example.js_deposit_provider.entity.DepositBig;
import com.example.js_deposit_provider.service.DepositBigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DepositBig)表控制层
 *
 * @author makejava
 * @since 2018-11-16 19:58:52
 */
@RestController
public class DepositBigController {
    /**
     * 服务对象
     */
    @Resource
    private DepositBigService depositBigService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
//    @GetMapping("selectOne")
//    public DepositBig selectOne(Integer id) {
//        return this.depositBigService.queryById(id);
//    }

    /**
     * 添加大额存款订单信息
     * @param depositBig
     * @return
     */
    @RequestMapping(value = "bigaddinform",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public  String addinform(DepositBig depositBig){
        return depositBigService.insert(depositBig);
    }

    /**
     * 查看用户的所有大额订单信息
     * @param userid
     * @return
     */
    @RequestMapping(value = "getBigInformById",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public String getInformById(String userid){
        return depositBigService.getAllById(userid);
    }

    /**
     * 提前取款
     * @param informid
     * @param money
     * @return
     */
    @RequestMapping(value = "BiggetMoney",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public String getmoney(String informid ,String money){
        return  depositBigService.getMoney(informid,money);
    }
}