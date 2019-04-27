package cn.njyazheng.md;

import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.util.encoders.Hex;

public class BouncyCastleMD5 {
    //加密
    public static String encrypt(String src) {
        MD5Digest digest = new MD5Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] md5Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md5Bytes, 0);
        // Hex.toHexString()将byte[]数组转换成十六进制字符串
       return  Hex.toHexString(md5Bytes);
    }
}
