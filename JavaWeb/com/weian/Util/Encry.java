package com.weian.Util;
import sun.misc.BASE64Encoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Encry {
    //密码加密
    public static String getEncryption(String password){
            String newpsw = null;
        try {
            //MD5 加密方式
            MessageDigest m = MessageDigest.getInstance("MD5");
            BASE64Encoder bs = new BASE64Encoder();
            newpsw = bs.encode(m.digest(password.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return newpsw;
    }

}
