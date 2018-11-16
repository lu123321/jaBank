package com.cloud.jsproducermanage.controller;

import com.cloud.jsproducermanage.entity.Financialtypelist;
import com.cloud.jsproducermanage.service.FinancialtypelistService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Financialtypelist)表控制层
 *
 * @author makejava
 * @since 2018-11-10 08:53:04
 */
@RestController
@RequestMapping("financialtypelist")
public class FinancialtypelistController {
    /**
     * 服务对象
     */
    @Resource
    private FinancialtypelistService financialtypelistService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Financialtypelist selectOne(Integer id) {
        return this.financialtypelistService.queryById(id);
    }

}