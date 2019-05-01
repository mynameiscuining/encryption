package cn.njyazheng.dh;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class JDKDH_B {
    //步骤二
    //公钥
    private String public_key_B;
    //私钥
    private String private_key_B;
    //钥
    
    private String public_key_A;
    
    public String getPublic_key_B() {
        return public_key_B;
    }
    
    public String getPrivate_key_B() {
        return private_key_B;
    }

    //步骤二
    public void setKeys(String public_key_A) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        this.public_key_A=public_key_A;
        X509EncodedKeySpec x509KeySpec=new X509EncodedKeySpec(Base64.decodeBase64(public_key_A));
        //实例化密钥工厂
        KeyFactory keyFactory=KeyFactory.getInstance("DH");
        //产生公钥
        PublicKey pubKey=keyFactory.generatePublic(x509KeySpec);
        //由甲方的公钥构造乙方密钥
        DHParameterSpec dhParamSpec=((DHPublicKey)pubKey).getParams();
        //实例化密钥生成器
        KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance(keyFactory.getAlgorithm());
        //初始化密钥生成器
        keyPairGenerator.initialize(dhParamSpec);
        //产生密钥对
        KeyPair keyPair=keyPairGenerator.genKeyPair();
        //乙方公钥
        DHPublicKey publicKey=(DHPublicKey)keyPair.getPublic();
        //乙方私钥
        DHPrivateKey privateKey=(DHPrivateKey)keyPair.getPrivate();
        public_key_B= Base64.encodeBase64String(publicKey.getEncoded());
        private_key_B= Base64.encodeBase64String(privateKey.getEncoded());
    }
    //获取密钥
    public String getSecretKey() throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException {
        //实例化密钥工厂
        KeyFactory keyFactory=KeyFactory.getInstance("DH");
        //初始化公钥
        //密钥材料转换
        X509EncodedKeySpec x509KeySpec=new X509EncodedKeySpec(Base64.decodeBase64(public_key_A));
        //产生公钥
        PublicKey pubKey=keyFactory.generatePublic(x509KeySpec);
        //初始化私钥
        //密钥材料转换
        PKCS8EncodedKeySpec pkcs8KeySpec=new PKCS8EncodedKeySpec(Base64.decodeBase64(private_key_B));
        //产生私钥
        PrivateKey priKey=keyFactory.generatePrivate(pkcs8KeySpec);
        //实例化
        KeyAgreement keyAgree=KeyAgreement.getInstance(keyFactory.getAlgorithm());
        //初始化
        keyAgree.init(priKey);
        keyAgree.doPhase(pubKey, true);
        //生成本地密钥
        /**
         * 由于JDK版本不同，在Java 8 update 161版本以后就会出现此问题，根本原因还是DH密钥长度至少为512位，而DES算法密钥没有这么长，密钥长度不一致引起的。
         *
         * 解决方法：
         *
         * 配置JVM的系统变量：-Djdk.crypto.KeyAgreement.legacyKDF=true
         */
        SecretKey secretKey=keyAgree.generateSecret("AES");
        return Base64.encodeBase64String(secretKey.getEncoded());
        
    }
    //用B的密钥钥解密,b和A的相同
    public String  decrypt(String target) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {
        //生成本地密钥
        SecretKey secretKey=new SecretKeySpec(Base64.decodeBase64(getSecretKey()),"AES");
        //数据解密
        Cipher cipher=Cipher.getInstance(secretKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte []result = cipher.doFinal(Base64.decodeBase64(target));
        return new String(result);
    }
}
