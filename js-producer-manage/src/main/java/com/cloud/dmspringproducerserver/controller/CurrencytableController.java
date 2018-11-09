package com.cloud.dmspringproducerserver.controller;

import com.cloud.dmspringproducerserver.entity.Currencytable;
import com.cloud.dmspringproducerserver.service.CurrencytableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Currencytable)表控制层
 *
 * @author makejava
 * @since 2018-11-08 22:11:34
 */
@RestController
@RequestMapping("currencytable")
public class CurrencytableController {
    /**
     * 服务对象
     */
    @Resource
    private CurrencytableService currencytableService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Currencytable selectOne(Integer id) {
        return this.currencytableService.queryById(id);
    }

}