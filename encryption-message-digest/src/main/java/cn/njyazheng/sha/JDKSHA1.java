package cn.njyazheng.sha;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JDKSHA1 {
    //加密
    public static String encrypt(String source) throws NoSuchAlgorithmException {
        // SHA-1的名称就是SHA
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(source.getBytes());
       return Hex.encodeHexString(md.digest());
    }

}
