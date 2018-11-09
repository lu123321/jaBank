package com.cloud.jsconsumerremittance.controller;

import com.cloud.jsconsumerremittance.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/Userlogin",method = RequestMethod.GET)
    public String login(@RequestParam("count") int count){
        /*for (int i = 0; i< 10;i++){
            userService.login(i);
        }*/
//        return "666";
        return userService.login(count);
    }
}


