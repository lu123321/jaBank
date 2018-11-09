package com.cloud.dmspringproducerserver.controller;

import com.cloud.dmspringproducerserver.entity.Detailenquiry;
import com.cloud.dmspringproducerserver.service.DetailenquiryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Detailenquiry)表控制层
 *
 * @author makejava
 * @since 2018-11-08 22:06:09
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