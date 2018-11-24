package com.example.jsconsumerdeposit.service.impl;

import com.example.jsconsumerdeposit.pojo.DepositInform;
import com.example.jsconsumerdeposit.service.DepositInformService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@Component
public class DepositImformServiceImpl implements DepositInformService {
    @Override
    public String addinform(DepositInform depositInform) {
        return "订单生成出错";
    }
}
