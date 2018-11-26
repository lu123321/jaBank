package com.example.jsconsumerfinancial.controller;

import com.example.jsconsumerfinancial.service.FinancialService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FinancialController {

    //把二人的数据通过一个方法传到前台，就是所有有关其他服务的消费信息


    @Resource
    private FinancialService fs;

    /**
     * 展示信用卡还款信息
     * @param cardNumber
     * @return
     */
    @RequestMapping(value = "message",method = RequestMethod.POST)
    public String message(@RequestParam("cardNumber") String cardNumber){
        String menssage = fs.message(cardNumber);
        return menssage;
    }




}
