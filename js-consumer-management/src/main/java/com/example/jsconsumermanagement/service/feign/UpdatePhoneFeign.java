package com.example.jsconsumermanagement.service.feign;

import com.example.jsconsumermanagement.service.UpdatePhoneService;
import org.springframework.stereotype.Component;

@Component
public class UpdatePhoneFeign implements UpdatePhoneService {

    @Override
    public String updatePhone(String phone, String yanzheng) {
        return "验证失败";
    }

    @Override
    public String selectPhone(Integer userid) {
        return "骚等。。。。";
    }
}
