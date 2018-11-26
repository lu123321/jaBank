package com.example.jsconsumermanagement.service.feign;

import com.example.jsconsumermanagement.pojo.CreditcardCard;
import com.example.jsconsumermanagement.service.GuashiService;
import org.springframework.stereotype.Component;

@Component
public class GuashiFeign implements GuashiService {
    @Override
    public String update(CreditcardCard creditcardCard, Integer id, String cardNumber) {
        return "请稍后重试";
    }
}
