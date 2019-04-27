package cn.njyazheng.mac;

import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

public class BouncyCastleHMACMD5 {
    //加密
    public static String encrypt(String src,byte[]  key) {
        HMac hmac = new HMac(new MD5Digest());
        // 必须是16进制的字符，长度必须是2的倍数
        hmac.init(new KeyParameter(key));
        hmac.update(src.getBytes(), 0, src.getBytes().length);
        // 执行摘要
        byte[] hmacMD5Bytes = new byte[hmac.getMacSize()];
        hmac.doFinal(hmacMD5Bytes, 0);
        return Hex.toHexString(hmacMD5Bytes);
    }
}
