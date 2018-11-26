package com.example.jsconsumermanagement.controller;

import com.example.jsconsumermanagement.pojo.CreditcardCard;
import com.example.jsconsumermanagement.service.GuashiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GuashiController {

    @Resource
    private GuashiService gs;

    /**
     * 修改信用卡状态
     * @param creditcardCard
     * @return
     */
    @RequestMapping(value = "cardupdate",method = RequestMethod.POST)
    public String update(CreditcardCard creditcardCard, @RequestParam("id") Integer id, @RequestParam("cardNumber") String cardNumber){
        gs.update(creditcardCard,id,cardNumber);
        return "成功";
    }
}
