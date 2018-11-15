package com.example.jsdengluprovider.controller;


import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.service.BankMassgeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BankMessageController {
    @Resource
    private BankMassgeService bankMassgeService;

    @RequestMapping(value = "bankMassage",method = RequestMethod.POST)
    public String BankMassageSelect(@RequestParam("userid") Integer userid){
        return bankMassgeService.userSelect(userid);
    }
    @RequestMapping(value = "dealSelect",method = RequestMethod.POST)
    public String dealSelect(@RequestParam("bankcardid") Integer bankcardid){
        return bankMassgeService.dealSelect(bankcardid);
    }
    @RequestMapping(value = "delCard",method = RequestMethod.POST)
    public String delCard(@RequestParam("bankCard")BankCard bankCard){
        return bankMassgeService.delCard(bankCard);
    }
    @RequestMapping(value = "updateCard",method = RequestMethod.POST)
    public String updateCard(@RequestParam("cardid")Integer cardid){
        return bankMassgeService.updateCard(cardid);
    }
}
