package com.example.jsconsumermanagement.service;

import com.example.jsconsumermanagement.service.feign.ShowcardFeign;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "js-producer-creditcard",fallback =ShowcardFeign.class)
public interface ShowcardService {
    /**
     * 根据卡关联用户查询用户所有卡片
     * @param id
     * @return
     */
    @RequestMapping(value = "cardid",method = RequestMethod.POST)
    public String liss(@RequestParam("id") Integer id);




}
