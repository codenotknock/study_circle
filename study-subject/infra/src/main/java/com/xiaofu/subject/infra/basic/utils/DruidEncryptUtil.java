package com.xiaofu.subject.infra.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * 数据库加密
 * @author xiaofu
 * @date 2024/1/11 0:20
 */
public class DruidEncryptUtil {

    private static String publicKey;

    private static String privateKey;

    static {

        try {
            String[] keyPair = ConfigTools.genKeyPair(512);
            privateKey = keyPair[0];
            System.out.println("privateKey："+privateKey);
            publicKey = keyPair[1];
            System.out.println("publicKey："+publicKey);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }

    public static String encrypt(String plainText) throws Exception {
        String encrypt = ConfigTools.encrypt(privateKey, plainText);
        System.out.println("encrypt："+encrypt);
        return encrypt;
    }

    public static String decrypt(String encryptText) throws Exception {
        String decrypt = ConfigTools.decrypt(publicKey, encryptText);
        System.out.println("decrypt："+decrypt);
        return decrypt;
    }

    public static void main(String[] args) throws Exception {
        // 加密用私钥 解密用公钥   配置中暴露了公钥 还是不安全！！
        encrypt("admin");
        encrypt("xiaofu");
    }

}
