package com.example.js_deposit_provider.util;

public class AccountInfo {

    private static String operation = "/query/accountInfo";

    private static String accountSid = Config.ACCOUNT_SID;

    /**
     * 获取开发者账号信息
     */
    public static void execute()
    {
        String url = Config.BASE_URL + operation;
        String body = "accountSid=" + accountSid + HttpUtil.createCommonParam();

        // 提交请求
        String result = HttpUtil.post(url, body);
        System.out.println("result:" + System.lineSeparator() + result);
    }
}
