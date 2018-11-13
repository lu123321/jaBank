package com.example.jsconsumeroptions.service;

import com.example.jsconsumeroptions.service.impl.MarketingImpl;
import com.example.jsproduceroptions.entity.MarketingManagement;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(name = "js-producer-options",fallback = MarketingImpl.class)
public interface MarketingService {
    /**
     * 通过主键查询单条数据r
     *
     * @param userId 主键
     * @return 单条数据
     */
    @RequestMapping(value = "selectOne",method = RequestMethod.POST)
    public String selectOne(@RequestParam("userId") Integer userId,@RequestParam("number") Integer number);

    /**
     * 新增数据
     *
     * @param userid,name,marketing,phone,state 实例对象
     * @return 实例对象
     */
    @RequestMapping(value = "tianjia",method = RequestMethod.POST)
    public String tianjia(@RequestParam("userId") Integer userid,@RequestParam("name") String name,@RequestParam("marketing") String marketing
            ,@RequestParam("phone") String phone,@RequestParam("state") Integer state);

    /**
     * 查询多条数据
     *
     * @param id 用户id查询
     * @return 对象列表
     */
    @RequestMapping(value = "selectAll",method = RequestMethod.POST)
    public List<MarketingManagement> selectAll(@RequestParam("id") Integer id);


    /**
     * 通过主键删除数据
     *
     * @param userId 和 number 删除
     * @return 是否成功
     */
    @RequestMapping(value = "deleteById",method = RequestMethod.POST)
    public String deleteById(@RequestParam("userId") Integer userId,@RequestParam("number") Integer number);


    /**
     * 修改数据
     *
     * @param marketingManagement 实例对象
     * @return 实例对象
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public String update(MarketingManagement marketingManagement);
}
