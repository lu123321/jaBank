package com.example.jsconsumerdenglu.feign;

import com.example.jsconsumerdenglu.service.impl.UserFeignImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "js-producer-login",fallback = UserFeignImpl.class)
public interface UserFeign {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam("count")int conut);
}
