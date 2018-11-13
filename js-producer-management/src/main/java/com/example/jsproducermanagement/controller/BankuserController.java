package com.example.jsproducermanagement.controller;

import com.example.jsproducermanagement.entity.Bankuser;
import com.example.jsproducermanagement.service.BankuserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Bankuser)表控制层
 *
 * @author makejava
 * @since 2018-11-12 21:14:23
 */
@RestController
@RequestMapping("bankuser")
public class BankuserController {
    /**
     * 服务对象
     */
    @Resource
    private BankuserService bankuserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Bankuser selectOne(Integer id) {
        return this.bankuserService.queryById(id);
    }

}