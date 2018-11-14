package com.example.jsconsumeroptions.service;

import com.example.jsconsumeroptions.pojo.Appointment;
import com.example.jsconsumeroptions.service.impl.InvokeFeign;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "js-producer-account",fallback = InvokeFeign.class)
public interface InvokeService {
    /**
     * 查询网点预约接口
     * @param appointment
     * @return
     */
    @RequestMapping(value = "insertOne",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String insertOne(@RequestBody Appointment appointment);
}
