package com.cloud.jsproduceraccount.service.impl;

import com.cloud.jsproduceraccount.Voice.VoiceCode;
import com.cloud.jsproduceraccount.dao.DetailenquiryDao;
import com.cloud.jsproduceraccount.entity.Detailenquiry;
import com.cloud.jsproduceraccount.entity.Secondaccount;
import com.cloud.jsproduceraccount.dao.SecondaccountDao;
import com.cloud.jsproduceraccount.service.SecondaccountService;
import com.cloud.jsproduceraccount.uitl.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

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
    private DetailenquiryDao detailenquiryDao;
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
                    return "{\"500\":\"输入密码不一致\"}";
                }
            }catch (Exception e){
                e.printStackTrace();
                return "{\"500\":\"请输入6位数字密码\"}";
            }
        }
        return "{\"500\":\"请输入6位数字密码\"}";
    }

    /**
     * 通过查询单条数据
     *
     * @param accountUserid 用户ID
     * @return 实例对象
     */
    @Override
    public String queryById(Integer accountUserid) {
            try{
                Secondaccount secondaccount = this.secondaccountDao.queryById(accountUserid);
                String accountCard = secondaccount.getAccountCard();
                redisUtil.set("accountCard",accountCard,60*5);
                return "[{\"accountCard\":\" "+ accountCard +" \"}" + "," + "{\"openbank\":\"晋城银行\"}" + "," + "{\"rediskey\":\"accountCard\"}]" ;

            }catch (Exception e){
                e.printStackTrace();
                return "{\"rediskey\":\"没有此账户\"}";
            }
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
        String compare = Compare(pwdone, pwdtwo);
        if ("{\"500\":\"200\"}".equals(compare)){
        try{
//                if(redisUtil.hget("secondaccount",phone).equals(auth)){

            //验证身份证号
            String str = "[1-9]{2}[0-9]{4}(19|20)[0-9]{2}"
                    + "((0[1-9]{1})|(1[1-2]{1}))((0[1-9]{1})|([1-2]{1}[0-9]{1}|(3[0-1]{1})))"
                    + "[0-9]{3}[0-9x]{1}";
            String idnunber = secondaccount.getAccountIdnumber();
            Pattern pattern = Pattern.compile(str);
            boolean matches = pattern.matcher(idnunber).matches();
                    if (matches){


                        //只需要随机生成二类账户银行卡号

                        secondaccount.setAccountPwd(Integer.parseInt(pwdone));
                        int insert = this.secondaccountDao.insert(secondaccount);
                        if (insert > 0){
                            return "{\"500\":\"200\"}";
                        }
                        return "{\"500\":\"申请失败\"}";
                    }
                    return "{\"500\":\"请输入正确的身份证号·\"}";
               /* }else {
                    return "{\"500\":\"验证码错误,请输入正确验证码!\"}";
                }*/
            }catch (Exception e){
                e.printStackTrace();
                return "{\"500\":\"验证码错误,请输入正确验证码!\"}";
            }
        }
        return compare;
    }

    /**
     * 修改二类账户价格数据
     * 同时添加明细表  记录信息
     * @param
     * @return 实例对象
     */
    @Override
    public String update(String price,String paynumber,String accountCard) {
        try {
            double v = Double.parseDouble(price);
            //从redis根据健拿出二类卡号进行修改操作， 提高安全性
            Object o = redisUtil.get(accountCard);
            if (o == null){
                return "400"; //转账超时,请重新转账!
            }
            Secondaccount selprice = secondaccountDao.selprice((String)o);
            Double pri = 0.00;
                if (selprice == null){
                    pri += v;
                }else {
                    pri = selprice.getAccountPrice() + v;
                }
            int update = this.secondaccountDao.update(pri, (String) o);
            //删除redis里面的二类卡号
            redisUtil.del(accountCard);
            int insert = 0;
            if(update > 0){
                //添加价格之后 添加明细信息
                Detailenquiry de = new Detailenquiry();
                //卡号
                de.setDetailenquiryNumber((String) o);
                //交易时间
                de.setDetailenquiryData(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                //交易场所   在哪个平台或者实体交易
                de.setDetailenquiryPlace("二类账户汇款");
                //摘要 进行了什么操作
                de.setDetailenquiryAbstract("汇款");
                //交易国家
                de.setDetailenquiryCountries("CHN");
                //对方信息
                de.setDetailenquiryOtherinformation(paynumber);
                //钞汇标志
                de.setDetailenquiryPaper("钞");
                //资金流向
                de.setDetailenquiryFundflow(2);
                //余额
                de.setDetailenquiryBalance(pri.toString());
                //交易币种  默认 1 人名币
                de.setDetailenquiryTransactioncurrency(1);
                //交易金额
                de.setDetailenquiryMoney(price);
                //添加明细表
                insert = detailenquiryDao.insert(de);
            }
            return update > 0 && insert > 0?"付款成功!":"付款失败!";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "200";
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