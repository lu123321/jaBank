package com.example.jsdengluprovider.service.impl;


import com.alibaba.fastjson.JSON;
import com.example.jsdengluprovider.dao.BankMessageDao;
import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.service.BankMassgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BankMassageServiceImpl implements BankMassgeService {

    @Resource
    private BankMessageDao bankMessageDao;
    @Override
    public String userSelect(Integer userid) {
        List<BankCard> bankCards = bankMessageDao.userSelect(userid);
        return JSON.toJSONString(bankCards);
    }

    @Override
    public String dealSelect(Integer bankcardid) {
        return JSON.toJSONString(bankMessageDao.dealSelect(bankcardid));
    }

    @Override
    public String delCard(BankCard bankCard) {
        return JSON.toJSONString(bankMessageDao.delCard(bankCard));
    }

    @Override
    public String updateCard(Integer cardid) {
        return JSON.toJSONString(bankMessageDao.updateCard(cardid));
    }

}
