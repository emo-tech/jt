package com.sher.api.secret.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author sherxia92
 */
@Slf4j
public class Md5Utils {

    public static String genSignature(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(value.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : result) {
                //加盐
                int number = b & 0xff;
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    builder.append("0");
                }
                builder.append(str);
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("", e);
        }
        return "";
    }
}
