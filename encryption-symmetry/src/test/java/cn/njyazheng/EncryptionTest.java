package cn.njyazheng;

import cn.njyazheng.aes.BouncyCastleAES;
import cn.njyazheng.aes.JDKAES;
import cn.njyazheng.des.BouncyCastleDES;
import cn.njyazheng.des.JDKDES;

import cn.njyazheng.desede.BouncyCastle3DES;
import cn.njyazheng.desede.JDK3DES;
import cn.njyazheng.pbe.JDKPBE;
import org.junit.Before;
import org.junit.Test;


public class EncryptionTest {
    public final static String SOURCE = "cuining";

    @Before
    public void before() {
        System.out.println("加密字符串为:" + SOURCE);
    }

    @Test
    public void JDKDES() throws Exception {
        byte[] bytes=JDKDES.getKey();
        String target = JDKDES.encrypt(SOURCE,bytes);
        System.out.println("JDKDES加密之后为:" + target);
        System.out.println("JDKDES解密之后为:" + JDKDES.decrypt(target,bytes));
    }

    @Test
    public void BouncyCastleDES() throws Exception {
        byte[] bytes=BouncyCastleDES.getKey();
        String target = BouncyCastleDES.encrypt(SOURCE,bytes);
        System.out.println("BouncyCastleDES加密之后为:" + target);
        System.out.println("BouncyCastleDES解密之后为:" + BouncyCastleDES.decrypt(target,bytes));
    }
    @Test
    public void compareDES1() throws Exception {
        byte[] bytes=JDKDES.getKey();
        String target = JDKDES.encrypt(SOURCE,bytes);
        System.out.println("JDKDES加密之后为:" + target);
        System.out.println("BouncyCastleDES解密之后为:" + BouncyCastleDES.decrypt(target,bytes));
    }
    @Test
    public void compareDES2() throws Exception {
        byte[] bytes=BouncyCastleDES.getKey();
        String target = JDKDES.encrypt(SOURCE,bytes);
        System.out.println("JDKDES加密之后为:" + target);
        System.out.println("BouncyCastleDES解密之后为:" + BouncyCastleDES.decrypt(target,bytes));
    }
    @Test
    public void compareDES3() throws Exception {
        byte[] bytes=BouncyCastleDES.getKey();
        String target = BouncyCastleDES.encrypt(SOURCE,bytes);
        System.out.println("BouncyCastleDES加密之后为:" + target);
        System.out.println("JDKDES解密之后为:" + JDKDES.decrypt(target,bytes));
    }
    @Test
    public void JDK3DES() throws Exception {
        byte[] bytes=JDK3DES.getKey();
        String target = JDK3DES.encrypt(SOURCE,bytes);
        System.out.println("JDK3DES加密之后为:" + target);
        System.out.println("JDK3DES解密之后为:" + JDK3DES.decrypt(target,bytes));
    }

    @Test
    public void BouncyCastle3DES() throws Exception {
        byte[] bytes=BouncyCastle3DES.getKey();
        String target = BouncyCastle3DES.encrypt(SOURCE,bytes);
        System.out.println("BouncyCastle3DES加密之后为:" + target);
        System.out.println("BouncyCastle3DES解密之后为:" + BouncyCastle3DES.decrypt(target,bytes));
    }

    @Test
    public void compare3DES1() throws Exception {
        byte[] bytes=JDK3DES.getKey();
        String target = BouncyCastle3DES.encrypt(SOURCE,bytes);
        System.out.println("BouncyCastle3DES加密之后为:" + target);
        System.out.println("JDK3DES解密之后为:" + JDK3DES.decrypt(target,bytes));
    }

    @Test
    public void JDKAES() throws Exception {
        byte[] bytes=JDKAES.getKey();
        String target = JDKAES.encrypt(SOURCE,bytes);
        System.out.println("JDKAES加密之后为:" + target);
        System.out.println("JDKAES解密之后为:" + JDKAES.decrypt(target,bytes));
    }

    @Test
    public void BouncyCastleAES() throws Exception {
        byte[] bytes=BouncyCastleAES.getKey();
        String target = BouncyCastleAES.encrypt(SOURCE,bytes);
        System.out.println("BouncyCastleAES加密之后为:" + target);
        System.out.println("BouncyCastleAES解密之后为:" + BouncyCastleAES.decrypt(target,bytes));
    }

    @Test
    public void JDKPBE() throws Exception {
        byte[] bytes=JDKPBE.getSalt();
        String target = JDKPBE.encrypt(SOURCE,"kouling",bytes,50);
        System.out.println("JDKPBE加密之后为:" + target);
        System.out.println("JDKPBE解密之后为:" + JDKPBE.decrypt(target,"kouling",bytes,50));
    }
}
