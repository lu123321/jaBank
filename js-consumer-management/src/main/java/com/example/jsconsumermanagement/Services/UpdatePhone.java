package com.example.jsconsumermanagement.Services;

import com.example.jsconsumermanagement.service.UpdatePhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Component
public class UpdatePhone {

    @Autowired
    private UpdatePhoneService ups;

        //修改手机号码传入两个参数
        public String updatePhone(String phone,String yanzheng) {
            String sjh = "((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
            Pattern compile1 = Pattern.compile(sjh);
            Matcher matcher1 = compile1.matcher(phone);
            boolean matches1 = matcher1.matches();
            if (phone != null && yanzheng != null){
                if(matches1){
                    return ups.updatePhone(phone, yanzheng);
                }else {
                    return "格式不正确，请输入正确信息";
                }
            } else {
                return "输入正确的信息";
            }
        }

        //查找到用户的旧手机号码并发送验证码
        public String selectPhone(Integer userid){
            return ups.selectPhone(userid);
        }



}
