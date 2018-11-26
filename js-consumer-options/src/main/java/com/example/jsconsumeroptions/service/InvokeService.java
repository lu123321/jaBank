package com.example.jsconsumeroptions.service;

import com.example.jsconsumeroptions.pojo.Appointment;
import com.example.jsconsumeroptions.pojo.BankCard;
import com.example.jsconsumeroptions.service.impl.InvokeFeign;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "js-producer-account",fallback = InvokeFeign.class)
public interface InvokeService {
    /**
     * 查询网点预约接口
     * @param appointment
     * @return
     */
    @RequestMapping(value = "insertOne",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String insertOne(@RequestBody Appointment appointment);


    /**
     * 获取登录后个人所有信息
     * @param userid
     * @return
     */
    @RequestMapping(value = "bankCard",method = RequestMethod.POST)
    public List<BankCard> banCard(@RequestParam("userid") Integer userid);
}
