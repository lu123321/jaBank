package com.cloud.dmspringproducerserver.controller;

import com.cloud.dmspringproducerserver.entity.Branch;
import com.cloud.dmspringproducerserver.service.BranchService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Branch)表控制层
 *
 * @author makejava
 * @since 2018-11-08 22:02:39
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