package com.example.jsconsumerdeposit.service;

import com.example.jsconsumerdeposit.pojo.DepositInform;
import com.example.jsconsumerdeposit.service.impl.DepositImformServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 调用通知存款订单服务
 */
@FeignClient(name = "js-producer-deposit",fallback = DepositImformServiceImpl.class)
public interface DepositInformService {
    @RequestMapping(value = "addinform",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    @ResponseBody
    public String addinform(@RequestBody DepositInform depositInform);
}
