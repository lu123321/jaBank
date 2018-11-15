package com.example.jsdengluprovider.util.duanxin;

import java.net.URLEncoder;
import java.util.Random;

public class IndustrySMS {
    private static String operation = "/industrySMS/sendSMS";
    private static String accountSid = Config.ACCOUNT_SID;
    private static String smsContent = "【晋商银行】登录验证码：{1},如非本人操作，请忽略此短信。";
    private static String templateid= "13935580588";
    private static String param = new Random().nextInt(1000000)+"";
    /**
     * 验证码通知短信
     */
    public static String execute(String to)
    {
        String tmpSmsContent = null;
        try{
            tmpSmsContent = URLEncoder.encode(templateid, "UTF-8");
        }catch(Exception e){

        }
        String url = Config.BASE_URL + operation;
        String body = "accountSid=" + accountSid + "&to=" + to + "&templateid="+ templateid+HttpUtil.createCommonParam() +
                 "&param="+param ;

        // 提交请求
        String result = HttpUtil.post(url, body);
        System.out.println("result:" + System.lineSeparator() + result);
        return param;
    }
}
