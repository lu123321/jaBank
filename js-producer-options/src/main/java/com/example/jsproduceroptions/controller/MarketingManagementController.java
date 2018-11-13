package com.example.jsproduceroptions.controller;

import com.alibaba.fastjson.JSON;
import com.example.jsproduceroptions.entity.MarketingManagement;
import com.example.jsproduceroptions.service.MarketingManagementService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MarketingManagement)表控制层
 *
 * @author makejava
 * @since 2018-11-08 16:01:19
 */
@RestController
public class MarketingManagementController {
    /**
     * 服务对象
     */
    @Resource
    private MarketingManagementService marketingManagementService;

    /**
     * 通过主键查询单条数据
     *
     * @param userId 主键
     * @return 单条数据
     */
    @RequestMapping(value = "selectOne",method = RequestMethod.POST)
    public String selectOne(@RequestParam("userId") Integer userId,@RequestParam("number") Integer number) {
        String s = marketingManagementService.queryById(userId, number);
        return s;
    }

    /**
     * 新增数据
     *
     * @param name,marketing,phone,state 实例对象
     * @return 实例对象
     */
    @RequestMapping(value = "tianjia",method = RequestMethod.POST)
    public String tianjia(@RequestParam("userId") Integer userid,@RequestParam("name") String name,@RequestParam("marketing") String marketing
                    ,@RequestParam("phone") String phone,@RequestParam("state") Integer state){
        String insert = marketingManagementService.insert(userid,name,marketing,phone,state);
        return JSON.toJSONString(insert);
    }

    /**
     * 查询多条数据
     *
     * @param id 用户id查询
     * @return 对象列表
     */
    @RequestMapping(value = "selectAll",method = RequestMethod.POST)
    public List<MarketingManagement> selectAll(@RequestParam("id") Integer id){
        return marketingManagementService.queryAll(id);
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 和 number 删除
     * @return 是否成功
     */
    @RequestMapping(value = "deleteById",method = RequestMethod.POST)
    public String deleteById(@RequestParam("userId") Integer userId,@RequestParam("number") Integer number){
        return marketingManagementService.deleteById(userId,number);
    }

    /**
     * 修改数据
     *
     * @param marketingManagement 实例对象
     * @return 实例对象
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public String update(MarketingManagement marketingManagement){
        return marketingManagementService.update(marketingManagement);
    }




}