package com.cloud.jsproduceraccount.controller;

import com.cloud.jsproduceraccount.entity.Secondaccount;
import com.cloud.jsproduceraccount.service.SecondaccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Secondaccount)表控制层
 *
 * @author makejava
 * @since 2018-11-10 08:50:53
 */
@RestController
public class SecondaccountController {
    /**
     * 服务对象
     */
    @Resource
    private SecondaccountService secondaccountService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("selectOne")
    public Secondaccount selectOne(Integer id) {
        return this.secondaccountService.queryById(id);
    }

    /**
     * 验证密码一致性
     * @param pwdone
     * @param pwdtwo
     * @return
     */
    @RequestMapping(value = "determinepwd",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String Comparepwd(String pwdone,String pwdtwo){
        return this.secondaccountService.Compare(pwdone,pwdtwo);
    }

    /**
     * 发送验证码
     * @return
     */
    @RequestMapping(value = "sendSMS",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String sendSMS(String phone){
    return this.secondaccountService.sendSMS(phone);
    }

    /**
     * 点击确定按钮，正式申请
     * @param secondaccount
     * @param pwdone
     * @param pwdtwo
     * @param auth
     * @param phone
     * @return
     */
    @RequestMapping(value = "applyfortwo",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String applyfor(Secondaccount secondaccount,String pwdone,String pwdtwo,String auth,String phone){
        return this.secondaccountService.insert(secondaccount,pwdone,pwdtwo,auth,phone);
    }
}