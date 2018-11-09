package com.cloud.dmspringproducerserver.controller;

import com.cloud.dmspringproducerserver.entity.Managemoney;
import com.cloud.dmspringproducerserver.service.ManagemoneyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Managemoney)表控制层
 *
 * @author makejava
 * @since 2018-11-08 22:10:43
 */
@RestController
@RequestMapping("managemoney")
public class ManagemoneyController {
    /**
     * 服务对象
     */
    @Resource
    private ManagemoneyService managemoneyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Managemoney selectOne(Integer id) {
        return this.managemoneyService.queryById(id);
    }

}