package cn.njyazheng;

import cn.njyazheng.des.BouncyCastleDES;
import cn.njyazheng.des.JDKDES;

import cn.njyazheng.desede.BouncyCastle3DES;
import cn.njyazheng.desede.JDK3DES;
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
}
