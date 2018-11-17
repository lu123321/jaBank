package com.example.js_deposit_provider.controller;

import com.example.js_deposit_provider.entity.DepositBusiness;
import com.example.js_deposit_provider.service.DepositBusinessService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DepositBusiness)表控制层
 *
 * @author makejava
 * @since 2018-11-10 09:18:59
 */
@RestController
public class DepositBusinessController {
    /**
     * 服务对象
     */
    @Resource
    private DepositBusinessService depositBusinessService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DepositBusiness selectOne(Integer id) {
        return this.depositBusinessService.queryById(id);
    }

    /**
     * 通过类型查询业务
     * @param typeid
     * @return
     */
    @RequestMapping(value = "getbytype",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
    public String getbytype(@RequestParam String typeid){
        return  depositBusinessService.getByType(typeid);
    }

    /**
     * 查询全部数据
     * @return
     */
    @RequestMapping(value = "getAllBusiness",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
    public  void getAllBusiness(){
        depositBusinessService.getAllBusiness();
    }
}