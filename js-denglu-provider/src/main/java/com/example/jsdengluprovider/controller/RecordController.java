package com.example.jsdengluprovider.controller;

import com.alibaba.fastjson.JSON;
import com.example.jsdengluprovider.pojo.Record;
import com.example.jsdengluprovider.service.RecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RecordController {

    @Resource
    private RecordService rs;


    @RequestMapping(value ="selectAll",method = RequestMethod.POST)
    public String selectAll(@RequestParam("userid") Integer userid){
        List<Record> records = rs.selectAll(userid);
        return JSON.toJSONString(records);
    }

}
