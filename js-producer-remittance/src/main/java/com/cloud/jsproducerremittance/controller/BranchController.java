package com.cloud.jsproducerremittance.controller;

import com.cloud.jsproducerremittance.entity.Branch;
import com.cloud.jsproducerremittance.service.BranchService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Branch)表控制层
 *
 * @author makejava
 * @since 2018-11-10 08:52:16
 */
@RestController
@RequestMapping("branch")
public class BranchController {
    /**
     * 服务对象
     */
    @Resource
    private BranchService branchService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Branch selectOne(Integer id) {
        return this.branchService.queryById(id);
    }

}