package cn.njyazheng;

import org.bouncycastle.util.encoders.Base64;
// 用bouncy castle实现
public class BouncyCastleBase64 {
    //加密
    public static String encrypt(String src) {
        byte[] encodeBytes = Base64.encode(src.getBytes());
        return new String(encodeBytes);
    }

    //解密
    public static String decrypt(String target) {
        byte[] dencodeBytes = Base64.decode(target.getBytes());
        return new String(dencodeBytes);

    }
}
