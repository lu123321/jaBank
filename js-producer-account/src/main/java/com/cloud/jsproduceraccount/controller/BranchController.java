package com.cloud.jsproduceraccount.controller;

import com.cloud.jsproduceraccount.entity.Branch;
import com.cloud.jsproduceraccount.service.BranchService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * (Branch)表控制层
 *
 * @author makejava
 * @since 2018-11-12 10:41:38
 */
@RestController
public class BranchController {
    /**
     * 服务对象
     */
    @Resource
    private BranchService branchService;

    /**
     * 根据ID查询单个网点地址
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "selectOnesite",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String selectOne(Integer id) {
        return this.branchService.queryById(id);
    }

    /**
     *根据业务类型查询可以办理业务的网点
     * @param branchBusinessone
     * @param branchBusinesstwo
     * @return
     */
    @RequestMapping(value = "allbranch",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String query(@RequestParam(value = "branchBusinessone",required = false) Integer branchBusinessone,@RequestParam(value = "branchBusinesstwo",required = false) Integer branchBusinesstwo){
        return branchService.query(branchBusinessone,branchBusinesstwo);
    }

    /**
     * 根据星期几和网点ID查询网点受理业务时间段
     * @param branchId
     * @param time
     * @return
     */
    @RequestMapping(value = "querytime",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String queryTime(@RequestParam("branchId") Integer branchId,@RequestParam("time") String time) throws ParseException {
        return branchService.queryIdAndTime(branchId,time);
    }

    /**
     * 根据ID查询网点信息
     * @param branchId
     * @return
     */
    @RequestMapping(value = "querybranch",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String queryaddid(@RequestParam("branchId") Integer branchId){
        return branchService.queryByallid(branchId);
    }
}