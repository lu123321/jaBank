package com.example.jsconsumeraccount.service;

import com.example.jsconsumeraccount.service.impl.CreditImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "js-producer-creditcard",fallback = CreditImpl.class)
public interface CreditService {
    /**
     * 消费信息记录 查询
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "consume",method = RequestMethod.POST)
    public String comsumeid(@RequestParam("id") Integer id);
}
