package com.cloud.jsproducermanage.controller;

import com.cloud.jsproducermanage.entity.Financialrecords;
import com.cloud.jsproducermanage.service.FinancialrecordsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Financialrecords)表控制层
 *
 * @author makejava
 * @since 2018-11-10 08:53:18
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