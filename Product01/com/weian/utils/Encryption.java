package com.weian.utils;

import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具
 */
public class Encryption {

    public static String setEncry(String oldPassword){

        try {
            //MD5 加密方式
            MessageDigest m = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
           return base64Encoder.encode(m.digest(oldPassword.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
