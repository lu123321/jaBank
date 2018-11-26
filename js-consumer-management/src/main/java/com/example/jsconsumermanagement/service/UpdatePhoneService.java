package com.example.jsconsumermanagement.service;

import com.example.jsconsumermanagement.service.feign.UpdatePhoneFeign;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "js-denglu-provider",fallback = UpdatePhoneFeign.class)
public interface UpdatePhoneService {
    //修改手机号码
    @RequestMapping(value = "updatePhone",method = RequestMethod.POST)
    public String updatePhone(@RequestParam("phone")String phone,@RequestParam("yanzheng") String yanzheng);



    //通过传入id获得该用户的手机号码
    @RequestMapping(value = "selectPhone",method = RequestMethod.POST)
    public String selectPhone(@RequestParam("userid") Integer userid);


}
