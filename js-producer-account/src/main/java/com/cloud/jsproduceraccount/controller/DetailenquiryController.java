package com.cloud.jsproduceraccount.controller;

import com.cloud.jsproduceraccount.entity.Detailenquiry;
import com.cloud.jsproduceraccount.service.DetailenquiryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Detailenquiry)表控制层
 *
 * @author makejava
 * @since 2018-11-10 08:50:36
 */
@RestController
@RequestMapping("detailenquiry")
public class DetailenquiryController {
    /**
     * 服务对象
     */
    @Resource
    private DetailenquiryService detailenquiryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Detailenquiry selectOne(Integer id) {
        return this.detailenquiryService.queryById(id);
    }

}