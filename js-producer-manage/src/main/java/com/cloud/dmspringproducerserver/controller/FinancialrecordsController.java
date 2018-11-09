package com.cloud.dmspringproducerserver.controller;

import com.cloud.dmspringproducerserver.entity.Financialrecords;
import com.cloud.dmspringproducerserver.service.FinancialrecordsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Financialrecords)表控制层
 *
 * @author makejava
 * @since 2018-11-08 22:11:15
 */
@RestController
@RequestMapping("financialrecords")
public class FinancialrecordsController {
    /**
     * 服务对象
     */
    @Resource
    private FinancialrecordsService financialrecordsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Financialrecords selectOne(Integer id) {
        return this.financialrecordsService.queryById(id);
    }

}