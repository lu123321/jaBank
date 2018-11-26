package com.example.jsconsumermanagement.controller;

import com.example.jsconsumermanagement.Services.UpdatePhone;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UphoneController {
    @Resource
    private UpdatePhone rs;


    @RequestMapping(value = "updatePhone",method = RequestMethod.POST)
    public String updatePhone(@RequestParam("phone")String phone,@RequestParam("yanzheng") String yanzheng){
        return rs.updatePhone(phone,yanzheng);
    }



    @RequestMapping(value = "selectPhone",method = RequestMethod.POST)
    public String selectPhone(@RequestParam("userid") Integer userid){
        return rs.selectPhone(userid);
    }





}
