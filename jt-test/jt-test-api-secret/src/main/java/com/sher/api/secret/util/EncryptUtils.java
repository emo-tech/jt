package com.sher.api.secret.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Administrator
 */
public class EncryptUtils {

    /**
     * 算法/模式/补码方式
     */
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    /**
     * 使用CBC模式， 需要一个向量iv， 可增加加密算法的强度
     */
    public static final String IV = "2233445566778899";


    public static byte[] base64Decode(String base64Code) throws IOException {
        return StringUtils.isEmpty(base64Code) ? null : new BASE64Decoder().decodeBuffer(base64Code);
    }

    private static String base64Encode(byte[] bytes) {
        String data = Base64.encodeBase64String(bytes);
        if (!StringUtils.isEmpty(data)) {
            // 处理一行超过76个字符换行问题
            return data.replaceAll("[\\s*\t\n\r]", "");
        } else {
            return  data;
        }
    }

    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        byte[] raw = decryptKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes, StandardCharsets.UTF_8);
    }

    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return StringUtils.isEmpty(encryptStr) ? null : aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }

    private static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        byte[] raw = encryptKey.getBytes();
        SecretKeySpec secretkeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, secretkeySpec, ivParameterSpec);
        return cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
    }

    public static int genSalt() {
        int salt = 0;
        while (true) {
            salt = (int) (Math.random() * 1000000);
            if (salt < 1000000 && salt > 99999) {
                break;
            }
        }
        return salt;
    }
}
