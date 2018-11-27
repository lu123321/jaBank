package com.example.jsdengluprovider.service.impl;

import com.example.jsdengluprovider.dao.BankRegisterDao;
import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.pojo.BankUser;
import com.example.jsdengluprovider.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private BankRegisterDao brd;
    @Resource
    private BankRegisterDao br;
//    根据selectState查状态是否有该用户信息添加信息,是否拥有银行卡(有则开通，否无法开通)
    /**
     * 输入个人信息，包括姓名，身份证号，性别，出生日期，职业，从事行业，行政级别，
     * 供养人口数，学历，婚姻状态，所在省份城市，上传身份证正反面照片，银行卡密码
     * 添加银行卡
     * @return
     */
    @Override
    public String addBankCard(BankUser bankuser, BankCard bankcard) {
        //用户输入卡号，判断数据库是否有此卡信息
        String cardnum = br.selectCardnum(bankcard.getCardnum());
        if(cardnum == null){
            if(b(bankcard)){
                bankcard.setCardid(0);
                bankcard.setState(0);
                bankcard.setWebcardstate(0);
                brd.addBankcard(bankcard);
                addBankUser(bankuser);
                return "成功";
            }else {
                return "重新填写信息";
            }
        }else {
            return "该卡已被注册";
        }
    }

    @Override
    public void addBankUser(BankUser bankuser) {
        if (a(bankuser)) {
            bankuser.setUserid(0);
            bankuser.setCredit(60);
            brd.addBankuser(bankuser);
        }
    }


    @Override
    public List<BankCard> selectOne(String phone) {
        if(!"".equals(phone)){
            List<BankCard> bankCards = brd.selectOne(phone);
            if(bankCards != null){
                return bankCards;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    /**
     *根据身份证查询是否开通网银信息
     * 根据表中是否身份证返回false不能再开通网银
     * @param idcard
     * @return
     */
    @Override
    public boolean selectState(String idcard) {
        String s = brd.selectState(idcard);
        if("1".equals(s)){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean a(BankUser bankuser) {
        //身份证验证
        String sfz = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        Pattern compile = Pattern.compile(sfz);
        Matcher matcher = compile.matcher(bankuser.getIdcard());
        boolean matches = matcher.matches();
        //添加用户信息表的信息不为空
        if(!("".equals(bankuser.getName()) && "".equals(bankuser.getIdcard()) && "".equals(bankuser.getProvince()) && "".equals(bankuser.getCity()) &&
                "".equals(bankuser.getImgurl()) && "".equals(bankuser.getJingpwd()) && "".equals(bankuser.getSex()) && "".equals(bankuser.getBirthday())
                && "".equals(bankuser.getPeople()) && "".equals(bankuser.getWork()) && "".equals(bankuser.getReservedms()) )) {
            //判断输入卡号的长度以及静态密码长度
            if ( bankuser.getIdcard().length() == 18 && bankuser.getJingpwd().length()==6) {
                //身份验证成功返回true
                if (!matches) {
                    return false;
                } else {
                    return true;
                }
            }else{
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public boolean b(BankCard bankcard) {
        String sjh = "((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        String yhk ="^([1-9]{1})(\\d{14}|\\d{18})$";
//        String mm ="^[A-Za-z0-9]{8,32}$";

        Pattern compile1 = Pattern.compile(sjh);
        Pattern compile2 = Pattern.compile(yhk);
//        Pattern compile3 =Pattern.compile(mm);

        Matcher matcher1 = compile1.matcher(bankcard.getPhone());
        Matcher matcher2 = compile2.matcher(bankcard.getCardnum());
//        Matcher matcher3 = compile3.matcher(bankcard.getWebpwd());

        boolean matches1 = matcher1.matches();
        boolean matches2 = matcher2.matches();
//        boolean matches3 = matcher3.matches();

        if(!("".equals(bankcard.getCardtype()) && "".equals(bankcard.getCardnum()) && "".equals(bankcard.getUserpwd()) &&
            "".equals(bankcard.getUserid()) && "".equals(bankcard.getBalance()) && "".equals(bankcard.getCarddate())
            && "".equals(bankcard.getBranchname()) && "".equals(bankcard.getAvailablebalance()))){
            if(bankcard.getUserpwd().length() == 6 && bankcard.getPhone().length()==11 && bankcard.getCardnum().length()==19){
                if (matches1 && matches2 ){
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    //通过银行卡号找到网银状态
    @Override
    public String selectCard(String cardnum,String idcard,String phone) {
        String s = br.selectCard(cardnum);
        if(s.equals(1)){
            return "该卡已注册";
        }else {
            String s1 = br.selectPhone(cardnum);
            if(s1.equals(phone)){
                String s2 = br.selectUserid(cardnum);
                String s3 = br.selectIdcard(Integer.parseInt(s2));
                if(idcard.equals(s3)){
                    br.updateState(cardnum);
                    return "开通成功";
                }else {
                    return "身份信息不一致";
                }
            }else {
                return "手机信息不一致";
            }
        }
    }





}
