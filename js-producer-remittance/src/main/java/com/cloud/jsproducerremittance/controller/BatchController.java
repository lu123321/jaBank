package com.cloud.jsproducerremittance.controller;

import com.cloud.jsproducerremittance.entity.Batch;
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
@RequestMapping("batch")
public class BatchController {
    /**
     * 服务对象
     */
    @Resource
    private BatchService batchService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Batch selectOne(Integer id) {
        return this.batchService.queryById(id);
    }

}