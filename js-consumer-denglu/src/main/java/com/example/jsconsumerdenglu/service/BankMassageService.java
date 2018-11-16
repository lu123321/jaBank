package com.example.jsconsumerdenglu.service;

import com.example.jsconsumerdenglu.service.impl.BankMassageServiceImpl;
import com.example.jsconsumerdenglu.service.impl.UserFeignImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(name = "js-producer-login",fallback = BankMassageServiceImpl.class)
public interface BankMassageService {

    @RequestMapping(value = "bankMassage",method = RequestMethod.POST)
    public String BankMassageSelect(@RequestParam("userid") Integer userid);
}
