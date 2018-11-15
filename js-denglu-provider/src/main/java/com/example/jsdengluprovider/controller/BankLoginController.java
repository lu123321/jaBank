package com.example.jsdengluprovider.controller;


import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.service.BankLoginService;
import com.example.jsdengluprovider.util.JWT.CreatUtil;
import com.example.jsdengluprovider.util.model.ResultMap;

import com.example.jsdengluprovider.util.redis.RedisUtil;
import com.example.jsdengluprovider.util.shiro.Realm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class BankLoginController {
    @Resource
    private final BankLoginService bankLoginService;
    @Resource
    private Realm realm;
    @Resource
    RedisUtil redisUtil;
    public BankLoginController(BankLoginService bankLoginService) {
        this.bankLoginService = bankLoginService;
    }
    @RequestMapping(value = "/home")
    public String home(Model model){

        return "/test";
    }

    @RequestMapping(value = "/login")
        public ModelAndView Login(String name, String password, ModelAndView model)
            throws ServletException,IOException {
        final String sjh = "((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        final String yhk = "^([1-9]{1})(\\d{14}|\\d{18})$";
        final String username = "^[A-Za-z0-9]{8,32}$";

        Pattern compile1 = Pattern.compile(sjh);
        Pattern compile2 = Pattern.compile(yhk);
        Pattern compile = Pattern.compile(username);
        Matcher matcher1 = compile1.matcher(name);
        Matcher matcher2 = compile2.matcher(name);
        Matcher matcher = compile.matcher(name);
        boolean matches1 = matcher1.matches();
        boolean matches2 = matcher2.matches();
        boolean matches = matcher.matches();
        System.out.println(matches + "" + matches1 + "" + matches2);
        System.out.println("**************************************88");
        if ("".equals(name) && "".equals(password)) {
            model.setViewName("/login");
            return model;
        } else {
            if (matches && !matches1&&!matches2){
                Integer integer = bankLoginService.stateSelect2(name);
                aa(integer,name,password,model);
                return model;
            }
            if (matches1&&!matches2) {
                Integer integer = bankLoginService.stateSelect1(name);
                aa(integer,name,password,model);
                return model;
            }
            if (matches2) {
                Integer integer = bankLoginService.stateSelect(name);
                aa(integer,name,password,model);
                return model;
            } else {
                model.setViewName("/login");
                return model;
            }
        }
    }
    public ModelAndView aa(int integer,String name,String password,ModelAndView model){
        if (integer == 1){
            //获取subject
            Subject subject = SecurityUtils.getSubject();
            //封装用户数据
            UsernamePasswordToken token = new UsernamePasswordToken(name,password);
            try {
                //执行登录方法
                subject.login(token);
                int getid = realm.getid();
                String t = (String) redisUtil.get(getid + "token");
                model.setViewName("/test");
                model.addObject("token",t);
                model.addObject("id",getid);

                return model;
            }catch (UnknownAccountException e){
                e.printStackTrace();
                model.addObject("msg","用户名错误");
                model.setViewName("/login");
                return model;
            }catch (IncorrectCredentialsException e){
                e.printStackTrace();
                model.addObject("msg","密码错误");
                model.setViewName("login");
                return model;
            }
        }else {
            model.setViewName("reg");
            return model;//没有注册页面
        }
    }
    @RequestMapping("/add")
    public String add(Model model){

        return "/user/add";
    }
    @RequestMapping("/update")
    public String update(Model model){

        return "/user/update";
    }
    @RequestMapping("/toLogin")
    public String login(Model model){

        return "/login";
    }
}
