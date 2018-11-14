package com.example.jsdengluprovider.service.impl;

import com.example.jsdengluprovider.dao.BankRegisterDao;
import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.pojo.BankUser;
import com.example.jsdengluprovider.service.RegisterService;
import com.example.jsdengluprovider.util.date.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private BankRegisterDao brd;
//    根据selectState查状态是否有该用户信息添加信息,是否拥有银行卡(有则开通，否无法开通)
    /**
     * 输入个人信息，包括姓名，身份证号，性别，出生日期，职业，从事行业，行政级别，
     * 供养人口数，学历，婚姻状态，所在省份城市，上传身份证正反面照片，银行卡密码
     * 添加银行卡
     * @param bankuser
     * @param bankcard
     * @return
     */
    @Override
    public String addBankuser(BankUser bankuser,BankCard bankcard) {
        BankUser bu = new BankUser();
        if (a(bankuser,bankcard)){
            bu.setUserid(0);
            bu.setName(bankuser.getName());
            bu.setIdcard(bankuser.getIdcard());
            bu.setProvince(bankuser.getProvince());
            bu.setCity(bankuser.getCity());
            bu.setImgurl(bankuser.getImgurl());
            bu.setCredit(60);
            bu.setJingpwd(bankuser.getJingpwd());
            bu.setSex(bankuser.getSex());
            bu.setBirthday(DateUtil.DchangeS(bankuser.getBirthday()));
            bu.setPeople(bankuser.getPeople());
            bu.setWork(bankuser.getWork());
            bu.setWebstate(1);
            bu.setReservedms(bankuser.getReservedms());
//            bu.setBankcarddate(DateUtil.DchangeS(bankuser.getBankcarddate()));
            brd.addBankuser(bu);
            addBankcard(bankcard);
            return "201";
        }else {
            return "202";
        }
    }

    @Override
    public void addBankcard(BankCard bankcard) {
        if(b(bankcard)){
            bankcard.setCardid(0);
            bankcard.setCardtype(bankcard.getCardtype());
            bankcard.setUserpwd(bankcard.getUserpwd());
            bankcard.setPhone(bankcard.getPhone());
            bankcard.setUserid(bankcard.getUserid());
            bankcard.setState(0);
            bankcard.setBalance(bankcard.getBalance());
            bankcard.setCarddate(DateUtil.DchangeS(bankcard.getCarddate()));
            bankcard.setWebcardstate(0);
            bankcard.setBranchname(bankcard.getBranchname());
            bankcard.setAvailablebalance(bankcard.getAvailablebalance());
            brd.addBankcard(bankcard);
        }
    }

    @Override
    public String updateBank(BankCard bankcard) {
        if(selectOne(bankcard.getPhone())){
//            if(bankcard)

        }else {

       }
        return null;
    }

    @Override
    public boolean selectOne(String phone) {
        if(!"".equals(phone)){
            String s = brd.selectOne(phone);
            if(!"1".equals(s)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
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
    public boolean a(BankUser bankuser, BankCard bankcard) {
        String mm ="^[A-Za-z0-9]{8,32}$";
        String sfz = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        String sjh = "((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        String yhk ="^([1-9]{1})(\\d{14}|\\d{18})$";

        Pattern compile = Pattern.compile(sfz);
        Pattern compile1 = Pattern.compile(sjh);
        Pattern compile2 = Pattern.compile(yhk);
        Pattern compile3 =Pattern.compile(mm);

        Matcher matcher = compile.matcher(bankuser.getIdcard());
        Matcher matcher1 = compile1.matcher(bankcard.getPhone());
        Matcher matcher2 = compile2.matcher(bankcard.getCardnum());
        Matcher matcher3 = compile3.matcher(bankcard.getWebpwd());

        boolean matches = matcher.matches();
        boolean matches1 = matcher1.matches();
        boolean matches2 = matcher2.matches();
        boolean matches3 = matcher3.matches();


        if(!("".equals(bankuser.getName()) && "".equals(bankuser.getIdcard()) && "".equals(bankuser.getProvince()) && "".equals(bankuser.getCity()) &&
                "".equals(bankuser.getImgurl()) && "".equals(bankuser.getJingpwd()) && "".equals(bankuser.getSex()) && "".equals(bankuser.getBirthday())
                && "".equals(bankuser.getPeople()) && "".equals(bankuser.getWork()) && "".equals(bankuser.getReservedms()) )) {

            if ( bankuser.getIdcard().length() == 18 && bankcard.getPhone().length()==11 && bankcard.getCardnum().length()==19 && bankuser.getJingpwd().length()==6) {
                if (!matches && !matches1 && !matches2 && !matches3) {
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
        if(!("".equals(bankcard.getCardtype()) && "".equals(bankcard.getCardnum()) && "".equals(bankcard.getUserpwd()) &&
            "".equals(bankcard.getUserid()) && "".equals(bankcard.getState()) && "".equals(bankcard.getBalance()) && "".equals(bankcard.getCarddate())
            && "".equals(bankcard.getWebcardstate()) && "".equals(bankcard.getBranchname()) && "".equals(bankcard.getAvailablebalance()))){
            if(bankcard.getUserpwd().length() == 6){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
