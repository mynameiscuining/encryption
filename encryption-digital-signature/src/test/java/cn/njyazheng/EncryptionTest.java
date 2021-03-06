package cn.njyazheng;
import cn.njyazheng.dsa.JDKDSA;
import cn.njyazheng.esdsa.JDKECDSA;
import cn.njyazheng.rsa.JDKRSA;
import org.junit.Before;
import org.junit.Test;


public class EncryptionTest {
    public final static String SOURCE = "cuining";

    @Before
    public void before() {
        System.out.println("加密字符串为:" + SOURCE);
    }

    @Test
    public void RAS() throws Exception {
        //初始化密钥对
        JDKRSA jdkrsa=new JDKRSA();
        jdkrsa.setKeys();
        System.out.println("公钥:"+jdkrsa.getPublic_key());
        System.out.println("私钥:"+jdkrsa.getPrivate_key());
        String target=jdkrsa.signature(SOURCE);
        System.out.println("JDKRSA签名:"+target);
        System.out.println("JDKRSA认证:"+jdkrsa.auth(SOURCE,target));
    }
    
    @Test
    public void DAS() throws Exception {
        //初始化密钥对
        JDKDSA jdkdsa=new JDKDSA();
        jdkdsa.setKeys();
        System.out.println("公钥:"+jdkdsa.getPublic_key());
        System.out.println("私钥:"+jdkdsa.getPrivate_key());
        String target=jdkdsa.signature(SOURCE);
        System.out.println("JDKDSA签名:"+target);
        System.out.println("JDKDSA认证:"+jdkdsa.auth(SOURCE,target));
    }
    
    @Test
    public void JDKECDSA() throws Exception {
        //初始化密钥对
        JDKECDSA jdkecdsa=new JDKECDSA();
        jdkecdsa.setKeys();
        System.out.println("公钥:"+jdkecdsa.getPublic_key());
        System.out.println("私钥:"+jdkecdsa.getPrivate_key());
        String target=jdkecdsa.signature(SOURCE);
        System.out.println("JDKECDSA签名:"+target);
        System.out.println("JDKECDSA认证:"+jdkecdsa.auth(SOURCE,target));
    }
   
}
