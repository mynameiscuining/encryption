package cn.njyazheng;

import cn.njyazheng.des.BouncyCastleDES;
import cn.njyazheng.des.JDKDES;

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
}
