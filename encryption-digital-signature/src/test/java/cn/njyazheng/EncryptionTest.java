package cn.njyazheng;
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
   
}
