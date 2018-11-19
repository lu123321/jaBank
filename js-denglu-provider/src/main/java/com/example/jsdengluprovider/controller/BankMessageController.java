package com.example.jsdengluprovider.controller;


import com.example.jsdengluprovider.dao.BankMessageDao;
import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.service.BankMassgeService;
import com.example.jsdengluprovider.util.duanxin.IndustrySMS;
import com.example.jsdengluprovider.util.redis.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BankMessageController {
    @Resource
    private BankMassgeService bankMassgeService;
    @Resource
    RedisUtil redisUtil;

    @Resource
    private BankMessageDao bankMessageDao;

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

    /**
     * 前台传入手机号码，进行修改
     * @return
     */
    @RequestMapping(value = "updatePhone",method = RequestMethod.POST)
    public String updatePhone(@RequestParam("phone")String phone,@RequestParam("yanzheng") String yanzheng){
        String execute = (String) redisUtil.get("execute");
        if(execute.equals(yanzheng)){
            bankMassgeService.updatePhone(phone);
            return "1";
        }else {
            return "0";
        }

    }



    @RequestMapping(value = "selectPhone",method = RequestMethod.POST)
    public String selectPhone(@RequestParam("userid") Integer userid){
//        Integer userid1 = (Integer) redisUtil.get("userid");
        String s = bankMessageDao.selectCardnum(userid,1);
        redisUtil.set("cardnum",s);
        String s1 = bankMassgeService.selectPhone(userid);
        String execute = IndustrySMS.execute(s1);
        redisUtil.set("execute",execute);
        return s1;
    }
}
