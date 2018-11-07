package com.example.jsproducermanagement.controller;


import com.example.jsproducermanagement.service.AmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AmountController {
    @Autowired
    private AmountService as;

    @RequestMapping(value = "")
    public String update(){
        return "";
    }
}
