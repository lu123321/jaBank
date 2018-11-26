package com.example.jsconsumermanagement.service.feign;

import com.example.jsconsumermanagement.service.ShowcardService;
import org.springframework.stereotype.Component;

@Component
public class ShowcardFeign implements ShowcardService{
    @Override
    public String liss(Integer id) {
        return "该用户没有信用卡信息";
    }


}
