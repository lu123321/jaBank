package com.example.jsconsumermanagement.service.feign;

import com.example.jsconsumermanagement.service.ShowIPService;
import org.springframework.stereotype.Component;

@Component
public class ShowIPImpl implements ShowIPService {
    @Override
    public String selectAll(Integer userid) {
        return "稍后再试";
    }
}
