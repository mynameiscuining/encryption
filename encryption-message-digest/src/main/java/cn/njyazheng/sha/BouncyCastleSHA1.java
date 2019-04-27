package cn.njyazheng.sha;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.util.encoders.Hex;

public class BouncyCastleSHA1 {
    //加密
    public static String encrypt(String source) {
        Digest digest = new SHA1Digest();
        digest.update(source.getBytes(), 0, source.getBytes().length);
        byte[] sha1Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(sha1Bytes, 0);
        return Hex.toHexString(sha1Bytes);
    }
}
