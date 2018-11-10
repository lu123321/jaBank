package com.example.js_deposit_provider.controller;

import com.example.js_deposit_provider.entity.DepositInform;
import com.example.js_deposit_provider.service.DepositInformService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DepositInform)表控制层
 *
 * @author makejava
 * @since 2018-11-10 09:18:58
 */
@Controller
public class DepositInformController {
    /**
     * 服务对象
     */
    @Resource
    private DepositInformService depositInformService;

    /**
     * 根据类型擦查询
     * 此处需要调服务判断余额是否足够
     * @param depositInform
     * @return
     */
    @RequestMapping(value = "addinform",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    @ResponseBody
    public String addinform(DepositInform depositInform){
        return  depositInformService.insert(depositInform);
    }
}