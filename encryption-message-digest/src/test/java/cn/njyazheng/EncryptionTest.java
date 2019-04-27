package cn.njyazheng;

import cn.njyazheng.mac.BouncyCastleHMACMD5;
import cn.njyazheng.mac.JDKHMACMD5;
import cn.njyazheng.md.BouncyCastleMD5;
import cn.njyazheng.md.CommonCodesMD5;
import cn.njyazheng.md.JDKMD5;
import cn.njyazheng.sha.BouncyCastleSHA1;
import cn.njyazheng.sha.CommonCodesSHA1;
import cn.njyazheng.sha.JDKSHA1;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class EncryptionTest {
    public final static String SOURCE = "cuining";

    @Before
    public void before() {
        System.out.println("加密字符串为:" + SOURCE);
    }

    @Test
    public void MD5() throws Exception {
        String target = JDKMD5.encrypt(SOURCE);
        System.out.println("JDKMD5加密之后为:" + target);
        System.out.println("BouncyCastleMD5加密之后为:" + BouncyCastleMD5.encrypt(SOURCE));
        System.out.println("CommonCodesMD5加密之后为:" + CommonCodesMD5.encrypt(SOURCE));
    }

    @Test
    public void SHA1() throws Exception {
        String target = JDKSHA1.encrypt(SOURCE);
        System.out.println("JDKSHA1加密之后为:" + target);
        System.out.println("BouncyCastleSHA1加密之后为:" + BouncyCastleSHA1.encrypt(SOURCE));
        System.out.println("CommonCodesSHA1加密之后为:" + CommonCodesSHA1.encrypt(SOURCE));
    }

    @Test
    public void HMACMD5() throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] bytes=JDKHMACMD5.getKey();
        System.out.println("JDKHMACMD5加密后:"+JDKHMACMD5.encrypt(SOURCE,bytes));
        System.out.println("BouncyCastleHMACMD5加密后:"+BouncyCastleHMACMD5.encrypt(SOURCE,bytes));
    }
}
