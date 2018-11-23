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
    public String updateState(@RequestParam("userid") Integer userid,@RequestParam("cardnum") String cardnum){
        return cs.updateState(userid,cardnum);
    }
}
