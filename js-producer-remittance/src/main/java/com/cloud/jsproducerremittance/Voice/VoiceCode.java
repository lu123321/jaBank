package com.cloud.jsproducerremittance.Voice;

import java.util.Random;

/**
 * 语音验证码接口
 * 
 * @ClassName: VoiceCode
 * @Description: 语音验证码接口
 *
 */

public class VoiceCode {

	private static int auth = new Random().nextInt(1000000);
	private static String operation = "/call/voiceCode";
	private static String accountSid = Config.ACCOUNT_SID;
	private static String verifyCode = auth + "";
	private static String playTimes = "3";

	/**
	 * 语音验证码
	 */
	public static String execute(String called) {
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&verifyCode=" + verifyCode + "&called=" + called
				+ "&playTimes=" + playTimes
				+ HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);
		return verifyCode;
	}
}
