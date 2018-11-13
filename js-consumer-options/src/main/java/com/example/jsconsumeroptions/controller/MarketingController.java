package com.example.jsconsumeroptions.controller;

import com.example.jsconsumeroptions.service.MarketingService;
import com.example.jsproduceroptions.entity.MarketingManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarketingController {

    @Autowired
    private MarketingService ms;

    @RequestMapping("selectOne")
    public String selectOne(@RequestParam("userId") Integer userId,@RequestParam("number") Integer number){
        String s = ms.selectOne(userId,number);
        return s;
    }

    @RequestMapping(value = "tianjia",method = RequestMethod.POST)
    public String tianjia(@RequestParam("userId") Integer userid,@RequestParam("name") String name,@RequestParam("marketing") String marketing
            ,@RequestParam("phone") String phone,@RequestParam("state") Integer state){
        return ms.tianjia(userid,name,marketing,phone,state);
    }

    @RequestMapping(value = "selectAll",method = RequestMethod.POST)
    public String selectAll(@RequestParam("id") Integer id){
        ms.selectAll(id);
        return "202";
    }

    @RequestMapping(value = "deleteById",method = RequestMethod.POST)
    public String deleteById(@RequestParam("userId") Integer userId,@RequestParam("number") Integer number){
        ms.deleteById(userId,number);
        return "203";
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public String update(MarketingManagement marketingManagement){
        ms.update(marketingManagement);
        return "204";
    }
}
