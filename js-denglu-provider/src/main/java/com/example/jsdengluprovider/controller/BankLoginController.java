package com.example.jsdengluprovider.controller;


import com.example.jsdengluprovider.dao.RecordMessageDao;
import com.example.jsdengluprovider.service.BankLoginService;
import com.example.jsdengluprovider.service.RecordService;
import com.example.jsdengluprovider.util.duanxin.IndustrySMS;
import com.example.jsdengluprovider.util.redis.RedisUtil;
import com.example.jsdengluprovider.util.shiro.Realm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class BankLoginController {
    @Resource
    private RecordMessageDao rm;
    @Resource
    private final BankLoginService bankLoginService;
    @Resource
    private RecordService rs;
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
        final String yhk = "^([1-9]{1})(\\d{18})$";
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
                subject.login(token);
                int getid = realm.getid();
                String t = (String) redisUtil.get(getid + "token");
                model.setViewName("/test");
                model.addObject("token",t);
                model.addObject("id",getid);
                //判断是否是在设备上第一次登陆
                String s = rs.selectRecord(getid);
                if(s == "1"){
                    //执行登录方法
                    return model;
                }else {
                    //给手机号发送验证码，通过id拿到手机号码。
               /*  解析token
                  String  o = (String) redisUtil.get(getid + "token");
                    byte[] secretKey = Base64.getEncoder().encode(CommonConstants.SECURITY_KEY.getBytes());
                    Claims body = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(o).getBody();
                    Integer id = (Integer) body.get("user");*/
                    String ss = rm.selectPhone(getid);
                    String execute = IndustrySMS.execute(ss);
                    redisUtil.set("yzm", execute,180);
//                    String yanz = null;
//                    yz(yanz);
                  /*  String s1 = rs.addRecord(getid);
                    String yzm = (String) redisUtil.get("yzm");
                    if(s1 == yzm){
                        return model;
                    }else {
                        model.setViewName("手机验证失败");*/
                    model.setViewName("yz");
                    return model;
//                    }
                }

            }catch (UnknownAccountException e){
                e.printStackTrace();
                model.addObject("msg","用户名错误");
                model.setViewName("login");
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

    @RequestMapping(value = "yz",method = RequestMethod.POST)
    public ModelAndView yz(String yanZheng,ModelAndView model){
        int getid = realm.getid();
        String yzm = (String) redisUtil.get("yzm");
        System.out.println(yzm + "=============" + yanZheng);

        if (yzm.equals(yanZheng)){
            rs.addRecord(getid);
            model.setViewName("test");
            return model;
        }else {
            redisUtil.del(getid + "token");
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            model.setViewName("login");
            return model;
        }
    }

}
