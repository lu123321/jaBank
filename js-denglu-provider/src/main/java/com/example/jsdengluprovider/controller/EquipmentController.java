package com.example.jsdengluprovider.controller;

import com.example.jsdengluprovider.pojo.Equipment;
import com.example.jsdengluprovider.service.EuquipmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EquipmentController {
    @Resource
    private EuquipmentService euquipmentService;

    @RequestMapping(value = "equSelect",method = RequestMethod.POST)
    public String equSelect(@RequestParam("equipmentid") Integer equipmentid){
        return euquipmentService.equSelect(equipmentid);
    }
    @RequestMapping(value = "equUpdate",method = RequestMethod.POST)
    public String equUpdate(@RequestParam("equipmentid") Integer equipmentid){
        return euquipmentService.equUpdate(equipmentid);
    }
    @RequestMapping(value = "equipmentid",method = RequestMethod.POST)
    public String equDel(Integer equipmentid){
        return euquipmentService.equDel(equipmentid);
    }
    @RequestMapping(value = "equAdd",method = RequestMethod.POST)
    public String equAdd(@RequestParam("equipment")Equipment equipment){
        return euquipmentService.equAdd(equipment);
    }
}
