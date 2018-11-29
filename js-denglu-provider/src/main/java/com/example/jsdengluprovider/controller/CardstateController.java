package com.example.jsdengluprovider.controller;

import com.example.jsdengluprovider.service.CardstateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CardstateController {
    @Resource
    private CardstateService cs;

    @RequestMapping(value = "updateState",method = RequestMethod.POST)
    public String updateState(@RequestParam("cardnum") String cardnum,@RequestParam("state") Integer state){
        return cs.updateState(cardnum,state);
    }

    @RequestMapping(value = "updateYuliu",method = RequestMethod.POST)
    public String updateYuliu(@RequestParam("reservedms")String reservedms,@RequestParam("userid")Integer userid){
        return cs.updateYuliu(reservedms,userid);
    }


}
