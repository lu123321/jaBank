package com.example.jsproducerloans.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.jsproducerloans.entity.LoansBus;
import com.example.jsproducerloans.entity.LoansIndent;
import com.example.jsproducerloans.service.LoansBusService;
import com.example.jsproducerloans.util.ExcleUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (LoansBus)表控制层
 *
 * @author makejava
 * @since 2018-11-20 11:01:16
 */
@RestController
public class LoansBusController {
    /**
     * 服务对象
     */
    @Resource
    private LoansBusService loansBusService;

    /**
     * 通过大类型得到所有小类型业务信息
     * @param typeid
     * @return
     */
    @RequestMapping(value ="getbusByType",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    public String getbusByType(String typeid){
        return loansBusService.getloanType(typeid);
    }

    /**
     * 获得所有的支行信息
     * @return
     */
    @RequestMapping(value ="getBankinfo",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    public String getBankinfo(){
        return loansBusService.getBankInfo();
    }
}
