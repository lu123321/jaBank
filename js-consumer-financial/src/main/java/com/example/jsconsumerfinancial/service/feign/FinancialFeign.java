package com.example.jsconsumerfinancial.service.feign;

import com.example.jsconsumerfinancial.service.FinancialService;
import org.springframework.stereotype.Component;

@Component
public class FinancialFeign implements FinancialService {
    @Override
    public String message(String cardNumber) {
        return "查询失败";
    }
}
