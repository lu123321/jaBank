package com.example.jsdengluprovider.controller;


import com.example.jsdengluprovider.bean.ResponseBean;
import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.service.BankLoginService;
import com.example.jsdengluprovider.util.JWT.JWTUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class BankLoginController {
    @Resource
    private BankLoginService bankLoginService;

    public BankLoginService getBankLoginService() {
        return bankLoginService;
    }

    public void setBankLoginService(BankLoginService bankLoginService) {
        this.bankLoginService = bankLoginService;
    }

    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String index(Model model){
        return "";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseBean bankLogin(@RequestParam("username")String username, @RequestParam("webpwd")String webpwd){
        BankCard bankCard = bankLoginService.usernameLogin(username,webpwd);
        if (bankCard.getWebpwd().equals(webpwd)){
            return new ResponseBean(200,"登陆成功",JWTUtil.sign(username,webpwd));
        }
        else {
            throw new UnauthorizedException();
        }
    }
}
