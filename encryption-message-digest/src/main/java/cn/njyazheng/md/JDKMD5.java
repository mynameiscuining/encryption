package cn.njyazheng.md;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JDKMD5 {
    //加密
    public static String encrypt(String src) throws NoSuchAlgorithmException {
        // 得到MD5加密的对象
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5Bytes = md.digest(src.getBytes());
        // Hex.encodeHexString()将byte[]数组转换成十六进制字符串
       return Hex.encodeHexString(md5Bytes);
    }
}
