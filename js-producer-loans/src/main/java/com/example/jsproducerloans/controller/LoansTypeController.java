package com.example.jsproducerloans.controller;

import com.example.jsproducerloans.entity.LoansType;
import com.example.jsproducerloans.service.LoansTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (LoansType)表控制层
 *
 * @author makejava
 * @since 2018-11-20 11:01:17
 */
@RestController
public class LoansTypeController {
    /**
     * 服务对象
     */
    @Resource
    private LoansTypeService loansTypeService;

    /**
     * 得到所有类型的接口
     * @return
     */
    @RequestMapping(value = "getloanType",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    public String getAllType(){
        return  loansTypeService.getAllType();
    }
}