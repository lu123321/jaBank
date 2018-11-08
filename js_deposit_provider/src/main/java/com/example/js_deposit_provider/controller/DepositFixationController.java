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
@RequestMapping("depositFixation")
public class DepositFixationController {
    /**
     * 服务对象
     */
    @Resource
    private DepositFixationService depositFixationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DepositFixation selectOne(Integer id) {
        return this.depositFixationService.queryById(id);
    }

}