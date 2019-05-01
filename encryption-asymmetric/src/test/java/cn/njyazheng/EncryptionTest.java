package cn.njyazheng;
import cn.njyazheng.dh.JDKDH_A;
import cn.njyazheng.dh.JDKDH_B;
import org.junit.Before;
import org.junit.Test;


public class EncryptionTest {
    public final static String SOURCE = "cuining";

    @Before
    public void before() {
        System.out.println("加密字符串为:" + SOURCE);
    }

    @Test
    public void DH() throws Exception {
        JDKDH_A jdkdh_a=new JDKDH_A();
        jdkdh_a.setKeys();
        JDKDH_B jdkdh_b=new JDKDH_B();
        jdkdh_b.setKeys(jdkdh_a.getPublic_key_A());
        jdkdh_a.setPublic_key_B(jdkdh_b.getPublic_key_B());
        System.out.println("A的公钥:"+jdkdh_a.getPublic_key_A());
        System.out.println("A的私钥:"+jdkdh_a.getPrivate_key_A());
        System.out.println("A的密钥:"+jdkdh_a.getSecretKey());

        System.out.println("B的公钥:"+jdkdh_b.getPublic_key_B());
        System.out.println("B的私钥:"+jdkdh_b.getPrivate_key_B());
        System.out.println("B的密钥:"+jdkdh_b.getSecretKey());
        //加密
        String target=jdkdh_a.encrypt(SOURCE);
        System.out.println("JDKDH_A的加密为"+target);
        System.out.println("JDKDH_B的解密为"+jdkdh_b.decrypt(target));
        
    }
    
}
