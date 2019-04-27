package cn.njyazheng;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class EncryptionTest {
    public final  static String SOURCE="cuining";
    @Before
    public void before(){
        System.out.println("加密字符串为:"+SOURCE);
    }
    @Test
    public void JDKBase64() throws IOException {
        String target=JDKBASE64.encrypt(SOURCE);
        System.out.println("JDKBase64加密之后为:"+target);
        System.out.println("JDKBase64解密之后为:"+JDKBASE64.decrypt(target));
    }

    @Test
    public void commonsCodesBase64() throws IOException {
        String commonsCodestarget=CommonsCodesBase64.encrypt(SOURCE);
        String jdktarget=JDKBASE64.encrypt(SOURCE);
        System.out.println("JDKBase64加密之后为:"+jdktarget);
        System.out.println("CommonsCodesBase64加密之后为:"+commonsCodestarget);
        System.out.println("CommonsCodesBase64解密之后为:"+CommonsCodesBase64.decrypt(commonsCodestarget));
    }

    @Test
    public void bouncyCastleBase64() throws IOException {
        String commonsCodestarget=CommonsCodesBase64.encrypt(SOURCE);
        String jdktarget=JDKBASE64.encrypt(SOURCE);
        String bouncyCastletarget=BouncyCastleBase64.encrypt(SOURCE);
        System.out.println("JDKBase64加密之后为:"+jdktarget);
        System.out.println("CommonsCodesBase64加密之后为:"+commonsCodestarget);
        System.out.println("bouncyCastleBase64加密之后为:"+bouncyCastletarget);
        System.out.println("bouncyCastleBase64解密之后为:"+BouncyCastleBase64.decrypt(bouncyCastletarget));
    }
}
