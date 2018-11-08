package com.cloud.dmspringconsumerserver.feign;


import com.cloud.dmspringconsumerserver.user.Impl.UserFeignImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "dm-spring-producer-zhanghu",fallback = UserFeignImpl.class)
public interface UserFeign {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam("count")int count);

}
