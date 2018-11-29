package com.example.jsdengluprovider.controller;

import com.alibaba.fastjson.JSON;
import com.example.jsdengluprovider.pojo.Record;
import com.example.jsdengluprovider.service.RecordService;
import com.example.jsdengluprovider.util.duanxin.IndustrySMS;
import com.example.jsdengluprovider.util.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RecordController {

    @Resource
    private RecordService rs;
    @Autowired
    private RedisUtil redisUtil;


    @RequestMapping(value ="selectAll",method = RequestMethod.POST)
    public String selectAll(@RequestParam("userid") Integer userid){
        System.out.println(userid);
        List<Record> records = rs.selectAll(userid);
        return JSON.toJSONString(records);
    }

    //输入手机号码，得到验证码
    @RequestMapping(value = "getYzm",method = RequestMethod.POST)
    public String getYzm(@RequestParam("phone") String phone){
        String execute = IndustrySMS.execute(phone);
        redisUtil.set("yanzhengma",execute);
        return execute;
    }
    //输入验证码，判断是否正确
    @RequestMapping(value = "yanZ",method = RequestMethod.POST)
    public String yanZ(@RequestParam("yanzheng")String yanzheng){
        String yanzhengma = (String) redisUtil.get("yanzhengma");
        if(yanzheng.equals(yanzhengma)){
            return "验证成功";
        }else {
            return "验证失败";
        }
    }

    //验证成功，进入新页面，输入姓名，身份证信息并获得到此用户id
    //页面在controller判断是否有此条信息，返回不同页面信息
    @RequestMapping(value = "selectXinxi",method = RequestMethod.POST)
    public String selectXinxi(@RequestParam("name")String name,@RequestParam("idcard")String idcard){
        return rs.selectXinxi(name,idcard);
    }

    //验证成功后，输入银行卡账号，卡密码判断是否拥有此卡并获得到此用户id
    @RequestMapping(value = "selectCardd",method = RequestMethod.POST)
    public String selectCardd(@RequestParam("cardnum")String cardnum,@RequestParam("userpwd")String userpwd){
        return rs.selectCard(cardnum,userpwd);
    }

    //成功进入修改密码页面，输入新密码，进行修改网银密码
    @RequestMapping(value = "updateUserpwd",method = RequestMethod.POST)
    public String updateUserpwd(@RequestParam("webpwd")String webpwd){
        String userid = (String) redisUtil.get("userid");
        int i = Integer.parseInt(userid);
        return rs.updateUserpwd(webpwd,i);
    }


}
