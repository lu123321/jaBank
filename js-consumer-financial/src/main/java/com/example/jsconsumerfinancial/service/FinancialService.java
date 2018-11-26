package com.example.jsconsumerfinancial.service;

import com.example.jsconsumerfinancial.service.feign.FinancialFeign;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "js-producer-creditcard",fallback =FinancialFeign.class)
public interface FinancialService {
    /**
     * 展示信用卡还款信息
     * @param cardNumber
     * @return
     */
    @RequestMapping(value = "message",method = RequestMethod.POST)
    public String message(@RequestParam("cardNumber") String cardNumber);
}
