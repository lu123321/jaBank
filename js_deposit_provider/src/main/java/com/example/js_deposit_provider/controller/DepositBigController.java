package com.example.js_deposit_provider.controller;

import com.example.js_deposit_provider.entity.DepositBig;
import com.example.js_deposit_provider.service.DepositBigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DepositBig)表控制层
 *
 * @author makejava
 * @since 2018-11-08 10:32:28
 */
@RestController
@RequestMapping("depositBig")
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
    @GetMapping("selectOne")
    public DepositBig selectOne(Integer id) {
        return this.depositBigService.queryById(id);
    }

}