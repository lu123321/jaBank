package com.example.jsconsumermanagement.service;

import com.example.jsconsumermanagement.pojo.CreditcardCard;
import com.example.jsconsumermanagement.service.feign.GuashiFeign;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "js-producer-creditcard",fallback =GuashiFeign.class)
public interface GuashiService {
    /**
     * 修改信用卡状态
     * @param creditcardCard
     * @return
     */
    @RequestMapping(value = "cardupdate",method = RequestMethod.POST)
    public String update(CreditcardCard creditcardCard, @RequestParam("id") Integer id, @RequestParam("cardNumber") String cardNumber);

}
