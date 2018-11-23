package com.cloud.jsproducerremittance.controller;

import com.cloud.jsproducerremittance.entity.Batch;
import com.cloud.jsproducerremittance.pojovalue.Batchvalue;
import com.cloud.jsproducerremittance.service.BatchService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Batch)表控制层
 *
 * @author makejava
 * @since 2018-11-10 08:51:40
 */
@RestController
public class BatchController {
    /**
     * 服务对象
     */
    @Resource
    private BatchService batchService;

    /**
     * 通过主键查询单条数据
     *
     * @param batid 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/selectOnebatch",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String selectOne(Integer batid) {
        return this.batchService.queryById(batid);
    }

    /**
     * 批量汇款
     * @param batch
     * @return
     */
    @RequestMapping(value = "/insertBatch",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String insertBatch(String batch){
        return batchService.insert(batch);
    }

    /**
     * 验证银行卡
     * @param number
     * @return
     */
    @RequestMapping(value = "/verifycard",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String verifycard(String number){
        return batchService.verifycard(number);
    }

    /**
     * 根据卡号和时间段查询批量明细 分页
     * @param ba
     * @return
     */
    @RequestMapping(value = "/querybatch",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String queryallbatch(Batchvalue ba){
       return batchService.queryAll(ba);
    }
}