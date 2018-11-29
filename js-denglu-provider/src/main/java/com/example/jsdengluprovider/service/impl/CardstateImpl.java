package com.example.jsdengluprovider.service.impl;

import com.example.jsdengluprovider.dao.CardstateDao;
import com.example.jsdengluprovider.service.CardstateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CardstateImpl implements CardstateService {
    @Resource
    private CardstateDao cd;


    @Override
    public String updateState(String cardnum,Integer state) {
        if (cardnum != null && state != null){
            //通过银行卡账号修改此卡状态
            cd.updateState(cardnum,state);
            return "修改成功";
        }else {
            return "输入不正确";
        }
    }

    @Override
    public String updateYuliu(String reservedms, Integer userid) {
        if(reservedms!=null){
            if(reservedms.length()<6){
                return "长度不合法";
            }else if (reservedms.length()>11){
                return "长度不合法";
            }else {
                int i = cd.updateYuliu(reservedms,userid);
                if(i==1){
                    return "修改成功";
                }else {
                    return "修改失败";
                }
            }
        }else {
            return "输入有误";
        }
    }
}
