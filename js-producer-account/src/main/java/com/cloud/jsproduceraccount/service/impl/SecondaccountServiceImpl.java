package com.cloud.jsproduceraccount.service.impl;

import com.cloud.jsproduceraccount.Voice.VoiceCode;
import com.cloud.jsproduceraccount.entity.Secondaccount;
import com.cloud.jsproduceraccount.dao.SecondaccountDao;
import com.cloud.jsproduceraccount.service.SecondaccountService;
import com.cloud.jsproduceraccount.uitl.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Secondaccount)表服务实现类
 *
 * @author makejava
 * @since 2018-11-10 08:50:53
 */
@Service
public class SecondaccountServiceImpl implements SecondaccountService {
    @Resource
    private SecondaccountDao secondaccountDao;
    @Resource
    private RedisUtil redisUtil;
    /**
     * 判断密码是否一致，和是否是6位数的密码
     * @param pwdone
     * @param pwdtwo
     * @return
     */
    @Override
    public String Compare(String pwdone, String pwdtwo) {

        if (pwdone.length() == 6 && pwdtwo.length() == 6){
           //可能会出现数字转换异常，String 接收是为了避免前台传汉字，Integer接收会报错。
            try{
                Integer integer = Integer.valueOf(pwdone);
                Integer integer1 = Integer.valueOf(pwdtwo);
                if (integer.equals(integer1)){
                    //是6位数字也相同
                    return "{\"500\":\"200\"}";
                }else {
                    //是6位数字但不相同
                    return "{\"500\":\"501\"}";
                }
            }catch (Exception e){
                e.printStackTrace();
                return "{\"500\":\"请输入6位数字密码\"}";
            }
        }
        return "{\"500\":\"请输入6位数字密码\"}";
    }

    /**
     * 通过ID查询单条数据
     *
     * @param accountId 主键
     * @return 实例对象
     */
    @Override
    public Secondaccount queryById(Integer accountId) {
        return this.secondaccountDao.queryById(accountId);
    }

    /**
     * 发送申请二类账户中语音验证码
     * @param phone
     * @return
     */
    @Override
    public String sendSMS(String phone) {
        String execute = VoiceCode.execute(phone);
        redisUtil.hset("secondaccount",phone,execute,1000*60*5);
        return "200";
    }


    /**
     * 新增数据
     *
     * @param secondaccount 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Secondaccount secondaccount,String pwdone,String pwdtwo,String auth,String phone) {
            Compare(pwdone, pwdtwo);
//        if ("{\"500\":\"200\"}".equals(compare)){
            try{
                Integer integer = Integer.valueOf(auth);
                if(redisUtil.hget("secondaccount",phone).equals(integer)){
                    int insert = this.secondaccountDao.insert(secondaccount);
                    if (insert > 0){
                        return "{\"500\":\"200\"}";
                    }
                    return "{\"500\":\"405\"}";
                }else {
                    return "{\"500\":\"验证码错误,请输入正确验证码!\"}";
                }
            }catch (Exception e){
                e.printStackTrace();
                return "{\"500\":\"验证码错误,请输入正确验证码!\"}";
            }
//        }
        //return "";
    }

    /**
     * 修改数据
     *
     * @param secondaccount 实例对象
     * @return 实例对象
     */
    @Override
    public Secondaccount update(Secondaccount secondaccount) {
        this.secondaccountDao.update(secondaccount);
        return this.queryById(secondaccount.getAccountId());
    }

    /**
     * 通过主键删除数据
     *
     * @param accountId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer accountId) {
        return this.secondaccountDao.deleteById(accountId) > 0;
    }
}