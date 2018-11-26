package com.example.jsconsumermanagement.service;

import com.example.jsconsumermanagement.service.feign.ShowIPImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "js-denglu-provider",fallback =ShowIPImpl.class)
public interface ShowIPService {
    /**
     * 显示用户个人的所有登录过的地址信息
     * @param userid
     * @return
     */
    @RequestMapping(value ="selectAll",method = RequestMethod.POST)
    public String selectAll(@RequestParam("userid") Integer userid);
}
