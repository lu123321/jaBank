package com.cloud.dmspringproducerserver.controller;

import com.cloud.dmspringproducerserver.entity.Remittancetransaction;
import com.cloud.dmspringproducerserver.service.RemittancetransactionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Remittancetransaction)表控制层
 *
 * @author makejava
 * @since 2018-11-08 22:08:12
 */
@RestController
@RequestMapping("remittancetransaction")
public class RemittancetransactionController {
    /**
     * 服务对象
     */
    @Resource
    private RemittancetransactionService remittancetransactionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Remittancetransaction selectOne(Integer id) {
        return this.remittancetransactionService.queryById(id);
    }

}