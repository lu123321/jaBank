package com.example.jsdengluprovider.util.jiami;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSAUtil {
    public  static  final  String RSA_ALGORITHM = "RSA";
    Map<String,byte[]> keyMap = new HashMap<String,byte[]>();
    //生成密钥对
    public void generateKeyPair(){
        try {
            //密钥对生成器
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            //初始化密钥长度
            keyPairGenerator.initialize(1024);
            //生成密钥对放入ketpair临时存储，存的是密钥的引用
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            //获得公钥
            RSAPublicKey publickey = (RSAPublicKey) keyPair.getPublic();
            //获得私钥
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            //公钥和私钥都有自己独特的比特编码，在实际使用中我们经常需要通过getEncoded()方法得到公钥和密钥的比特编码
            //byte[]然后存入本地文件呢，使用时再通过byte[]得到RSA公钥和私钥
            keyMap.put("private",privateKey.getEncoded());
            keyMap.put("public",publickey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    //得到私钥
    public  PrivateKey getPrivate(){
        PrivateKey privateKey = null;
        try {
            //获得到私钥的byte[]
            byte[] privates = keyMap.get("private");
            //通过byte[]得到PrivateKeyInfo进行编码，按照私钥的规则进行组装
            PKCS8EncodedKeySpec pri = new PKCS8EncodedKeySpec(privates);
            //初始化工厂
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            //得到私钥
            privateKey= keyFactory.generatePrivate(pri);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }
    //得到公钥
    public  PublicKey getPublic(){
        PublicKey publicKey = null;
        try {
            //获得到公钥的byte[]
            byte[] publics = keyMap.get("public");
            //通过byte[]得到PrivateKeyInfo进行编码，按照私钥的规则进行组装
            X509EncodedKeySpec pri = new X509EncodedKeySpec(publics);
            //初始化工厂
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            //得到私钥
            publicKey= keyFactory.generatePublic(pri);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    /**
     * 使用私钥加密
     * @param data
     * @return byte[]
     */
    public byte[] privateEncrypt(String data){
        PrivateKey aPrivate = getPrivate();
        System.out.println(aPrivate);
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE,aPrivate);
            byte[] result = cipher.doFinal(data.getBytes());
            return  result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 使用公钥解密
     * @param data
     * @return String
     */
    public  String publicDecrypt(byte[] data){
        PublicKey publicKey = getPublic();
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE,publicKey);
            byte[] result = cipher.doFinal(data);
            return new String(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 使用公钥加密
     * @param data
     * @return
     */
    public  byte[] publicEncrypt(String data){
        //获得公钥
        PublicKey publicKey = getPublic();
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE,publicKey);
            byte[] result = cipher.doFinal(data.getBytes());
            return  result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 使用私钥进行解密
     * @param date
     * @return
     */
    public  String privateDecrypt(byte[] date){
        PrivateKey aPrivate = getPrivate();
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE,aPrivate);
            byte[] result = cipher.doFinal(date);
            return  new String(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
