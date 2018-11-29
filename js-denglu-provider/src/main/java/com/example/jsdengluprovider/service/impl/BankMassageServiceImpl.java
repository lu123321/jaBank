package com.example.jsdengluprovider.service.impl;


import com.alibaba.fastjson.JSON;
import com.example.jsdengluprovider.dao.BankMessageDao;
import com.example.jsdengluprovider.dao.RecordMessageDao;
import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.service.BankMassgeService;
import com.example.jsdengluprovider.service.pojo.CardEntity;
import com.example.jsdengluprovider.util.redis.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankMassageServiceImpl implements BankMassgeService {
    @Resource
    RedisUtil redisUtil;
    @Resource
    private BankMessageDao bankMessageDao;
    @Resource
    private RecordMessageDao rmd;
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

    //修改手机号码
    @Override
    public int updatePhone(String phone) {
        if(phone != null ){
            //获得用户id        ????????????????????????
            String  cardnum = (String) redisUtil.get("cardnum");
            int i = bankMessageDao.updatePhone(phone, cardnum);
            return i;
        }else {
            return 0;
        }

    }

    @Override
    public String selectPhone(Integer userid) {
        redisUtil.set("userid",userid);
        return rmd.selectPhone(userid);
    }

    @Override
    public String selectAll(Integer userid) {
        List<BankCard> bankCards = bankMessageDao.selectAll(userid);
        return JSON.toJSONString(bankCards);
    }

    /**
     * 通过用户id查看用户卡的信息
     * @param userid
     * @return
     */
    @Override
    public String getAllCard(String userid) {
        List<BankCard> allCard = bankMessageDao.getAllCard(Integer.parseInt(userid));
        List<CardEntity> returncard = new ArrayList<CardEntity>();
        for (BankCard b : allCard){
            CardEntity c = new CardEntity();
            c.setCardId(b.getCardid());
            c.setCardNumber(b.getCardnum());
            c.setBalance(b.getBalance());
            returncard.add(c);
        }
        return JSON.toJSONString(returncard);
    }

    /**
     * 根据卡id查看卡中余额
     * @param cardid
     * @return
     */
    @Override
    public String getbalance(String cardid) {
        Double getbalance = bankMessageDao.getbalance(Integer.parseInt(cardid));
        return JSON.toJSONString(getbalance);
    }

}
