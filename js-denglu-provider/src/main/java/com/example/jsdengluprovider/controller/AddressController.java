package com.example.jsdengluprovider.controller;

import com.alibaba.fastjson.JSON;
import com.example.jsdengluprovider.pojo.Address;
import com.example.jsdengluprovider.service.AddressService;
import com.example.jsdengluprovider.util.IPUtil.JsonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AddressController {
    @Resource
    private AddressService addressService;

    @RequestMapping(value = "addSelect",method = RequestMethod.POST)
    public String addSelect(@RequestParam("userid") Integer userid){
        return addressService.addSelect(userid);
    }

    @RequestMapping(value = "delAddress",method = RequestMethod.POST)
    public String delAddress(Address address){
        return JSON.toJSONString(addressService.delAddress(address));
    }
    @RequestMapping(value = "updateAddress",method = RequestMethod.POST)
    public String updateAddress(Address address){
        return JSON.toJSONString(addressService.updateAddress(address));
    }
    @RequestMapping(value = "addAddress",method = RequestMethod.POST)
    public String addAddress(Address address){
        return JSON.toJSONString(addressService.addAddress(address));
    }
}
