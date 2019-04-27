package cn.njyazheng;

import org.apache.commons.codec.binary.Base64;

// 用Apache的common codes实现
public class CommonsCodesBase64 {
    //加密
    public static String encrypt(String src) {
        byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
        return new String(encodeBytes);
    }

    //解密
    public static String decrypt(String target) {
        byte[] dencodeBytes = Base64.decodeBase64(target.getBytes());
        return new String(dencodeBytes);
    }
}
