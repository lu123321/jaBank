package com.example.jsconsumerdeposit.controller;

import com.example.jsconsumerdeposit.pojo.DepositInform;
import com.example.jsconsumerdeposit.service.DepositInformService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class DepositInformController {
    @Resource
    DepositInformService depositInformService;

    @RequestMapping("Userlogin")
    @ResponseBody
    public String addinform(DepositInform depositInform){
        //此处先判断金额是否满足业务
//        if(depositInform.getDepositInformmoney() < 50000 ){
//            return "101"; //金额不满足业务要求
//        }else {
//            //此处需要调用查询余额的服务进行比较，看余额是否足够
//            if(余额 > depositInform.getDepositInformmoney()){
//                //调用扣款服务接口
//                //调用生成订单服务接口
        System.out.println(1111);
                return depositInformService.addinform(depositInform);
//            }else {
//                return "102"; //余额不足
//            }
//        }
    }
    @RequestMapping("text")
    @ResponseBody
    public void text(){
        System.out.println("123");
    }
}
