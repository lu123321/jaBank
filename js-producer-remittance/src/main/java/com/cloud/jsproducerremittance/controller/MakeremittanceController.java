package com.cloud.jsproducerremittance.controller;

import com.cloud.jsproducerremittance.entity.Makeremittance;
import com.cloud.jsproducerremittance.service.MakeremittanceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Makeremittance)表控制层
 *
 * @author makejava
 * @since 2018-11-22 20:51:09
 */
@RestController
public class MakeremittanceController {
    /**
     * 服务对象
     */
    @Resource
    private MakeremittanceService makeremittanceService;

    /**
     * 通过时间 用户ID 查询预约信息表
     *
     * @param
     * @return JSON字符串 对象集合
     */
    @RequestMapping(value = "/selectmakere",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String selectOne(String selmaker) {
        return this.makeremittanceService.queryAll(selmaker);
    }

    /**
     * 添加预约汇款信息
     * @param ma
     * @return
     */
    @RequestMapping(value = "/insertmakere",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String insetmaker(Makeremittance ma){
        return this.makeremittanceService.insert(ma);
    }

    /**
     * 根据预约编号 和用户ID 查询单条预约详细信息
     * @param selonemaker
     * @return  JSON字符串 对象
     */
    @RequestMapping(value = "/selonemaker",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String selonemaker(String selonemaker){
        return this.makeremittanceService.selonemaker(selonemaker);
    }

    /**
     * 根据预约编号和用户ID 修改撤销状态
     * @param updatamaker
     * @return
     */
    @RequestMapping(value = "/updatamaker",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String updatamaker(String updatamaker){
        return this.makeremittanceService.update(updatamaker);
    }

}