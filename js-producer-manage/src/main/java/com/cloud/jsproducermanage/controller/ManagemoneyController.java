package com.cloud.jsproducermanage.controller;

import com.cloud.jsproducermanage.entity.Managemoney;
import com.cloud.jsproducermanage.service.ManagemoneyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Managemoney)表控制层
 *
 * @author makejava
 * @since 2018-11-10 08:52:39
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