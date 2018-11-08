package com.example.js_deposit_provider.controller;

import com.example.js_deposit_provider.entity.DepositInform;
import com.example.js_deposit_provider.service.DepositInformService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DepositInform)表控制层
 *
 * @author makejava
 * @since 2018-11-08 10:32:29
 */
@RestController
@RequestMapping("depositInform")
public class DepositInformController {
    /**
     * 服务对象
     */
    @Resource
    private DepositInformService depositInformService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DepositInform selectOne(Integer id) {
        return this.depositInformService.queryById(id);
    }

}