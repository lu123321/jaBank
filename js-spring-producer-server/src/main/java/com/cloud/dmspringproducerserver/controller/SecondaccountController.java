package com.cloud.dmspringproducerserver.controller;

import com.cloud.dmspringproducerserver.entity.Secondaccount;
import com.cloud.dmspringproducerserver.service.SecondaccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Secondaccount)表控制层
 *
 * @author makejava
 * @since 2018-11-08 22:07:20
 */
@RestController
@RequestMapping("secondaccount")
public class SecondaccountController {
    /**
     * 服务对象
     */
    @Resource
    private SecondaccountService secondaccountService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Secondaccount selectOne(Integer id) {
        return this.secondaccountService.queryById(id);
    }

}