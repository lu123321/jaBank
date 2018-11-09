package com.cloud.dmspringproducerserver.controller;

import com.cloud.dmspringproducerserver.entity.Makeremittance;
import com.cloud.dmspringproducerserver.service.MakeremittanceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Makeremittance)表控制层
 *
 * @author makejava
 * @since 2018-11-08 22:09:48
 */
@RestController
@RequestMapping("makeremittance")
public class MakeremittanceController {
    /**
     * 服务对象
     */
    @Resource
    private MakeremittanceService makeremittanceService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Makeremittance selectOne(Integer id) {
        return this.makeremittanceService.queryById(id);
    }

}