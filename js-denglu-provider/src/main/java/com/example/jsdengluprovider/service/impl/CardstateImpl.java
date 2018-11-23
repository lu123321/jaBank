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
    public String updateState(Integer userid, String cardnum) {
        if(cardnum != null){
            cd.updateState(userid,cardnum);
            return "修改成功";
        }else {
            return "没有该条数据";
        }
    }
}
