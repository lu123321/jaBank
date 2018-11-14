package com.example.jsdengluprovider.util.jiami;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AESUtil {
    private  static  SecretKey secretKey;
    public static byte[] encrypt(String content) {
        try {
            //生成密钥生成器
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            //根据随机源数初始化密钥生成器，根据传入的种子生成128位随机源，种子一致生成的也一致
            kgen.init(128);
            //产生原始对称密钥
            secretKey = kgen.generateKey();
            //创建对应算法的密码器
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            //将原始数据转化位字节数组
            byte[] byteContent = content.getBytes();
            //根据密码和模式初始化密码器
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);// 初始化
            //加密数据
            byte[] result = cipher.doFinal(byteContent);
            System.out.println(result);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }  catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
    /**解密
     * @param content  待解密内容
     * @return
     */
    public static byte[] decrypt(byte[] content) {
        try {
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, secretKey);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
