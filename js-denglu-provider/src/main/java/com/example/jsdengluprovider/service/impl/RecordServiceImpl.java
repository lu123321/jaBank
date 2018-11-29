package com.example.jsdengluprovider.service.impl;

import com.example.jsdengluprovider.dao.RecordMessageDao;
import com.example.jsdengluprovider.pojo.Equipment;
import com.example.jsdengluprovider.pojo.Record;
import com.example.jsdengluprovider.service.RecordService;
import com.example.jsdengluprovider.util.IPUtil.IpUtil;
import com.example.jsdengluprovider.util.date.DateUtil;
import com.example.jsdengluprovider.util.redis.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RecordServiceImpl implements RecordService {

    @Resource
    private RecordMessageDao rm;

    @Resource
    private RedisUtil redisUtil;


    //添加用户每次登录信息
    @Override
    public void addRecord(Integer userid, HttpServletRequest request) {
        Record r = new Record();
            r.setUserid(userid);
            r.setIPconfig(IpUtil.getIpAddr(request));
            rm.addRecord(r);
    }

    @Override
    public String selectRecord(String IPconfig) {

        int s = rm.recordSelect(IPconfig);
        if(s != 0){
            return "1";
        }else {
            return "0";
        }
    }

    @Override
    public List<Record> selectAll(Integer userid) {
        List<Record> records = rm.selectAll(userid);
        return records;
    }

    //添加用户在陌生设备上登录信息
    @Override
    public void addEquipment(Integer userid,HttpServletRequest request) {
        Equipment e = new Equipment();
        e.setEquipmentid(0);
        e.setUserid(userid);
        String nowDateTime = DateUtil.getNowDateTime();
        e.setTime(nowDateTime);
        e.setEquipmentname("电脑");
        e.setIPconfig(IpUtil.getIpAddr(request));
        rm.addEquipment(e);
    }

    @Override
    public String selectXinxi(String name, String idcard) {
        String sfz = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        Pattern compile = Pattern.compile(sfz);
        Matcher matcher = compile.matcher(idcard);
        boolean matches = matcher.matches();
        if(name!= null && idcard!=null){
            if(matches){
                String userid = rm.getIdcard(name, idcard);
                if (userid != null){
                    redisUtil.set("userid",userid);
                    return "成功";
                }else {
                 return "没有此用户信息";
                }
            }else {
                return "信息填写不正确";
            }
        }else {
            return "请正确输入信息";
        }
    }

    @Override
    public String selectCard(String cardnum, String userpwd) {
        final String yhk = "^([1-9]{1})(\\d{18})$";
        Pattern compile2 = Pattern.compile(yhk);
        Matcher matcher2 = compile2.matcher(cardnum);
        boolean matches2 = matcher2.matches();
        if (cardnum!=null && userpwd!=null){
            if (matches2){
                String userid1 = rm.selectCardnum(cardnum,userpwd);
                if(userid1!=null){
                    String userid = (String) redisUtil.get("userid");
                    if (userid1.equals(userid)){
                        return "成功";
                    }else {
                        return "信息错误";
                    }
                }else {
                    return "没有此用户信息";
                }
            }else {
                return "信息填写不正确";
            }
        }else {
            return "请正确输入信息";
        }
    }

    @Override
    public String updateUserpwd(String webpwd, Integer userid) {
        if (webpwd!=null){
            if (webpwd.length()<7){
                return "密码长度不能小于7位";
            }else if (webpwd.length()>16){
                return "密码长度不能大于16位";
            }else {
                int i = rm.UpdateWebpwd(webpwd, userid);
                if(i==1){
                    return "修改成功";
                }else {
                    return "请重试";
                }
            }
        }else {
            return "";
        }
    }


}
