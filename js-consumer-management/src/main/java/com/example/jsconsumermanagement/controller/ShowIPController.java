package com.example.jsconsumermanagement.controller;

import com.example.jsconsumermanagement.service.ShowIPService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ShowIPController {

    @Resource
    private ShowIPService si;

    @RequestMapping(value ="selectAll",method = RequestMethod.POST)
    public String selectAll(@RequestParam("userid") Integer userid){
        return si.selectAll(userid);
    }
}
