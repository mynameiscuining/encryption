package cn.njyazheng.rsa;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

public class JDKRSA_A {
    //公钥
    private String public_key;
    //私钥
    private String private_key;
    
    public String getPublic_key() {
        return public_key;
    }
    
    public String getPrivate_key() {
        return private_key;
    }
    
    public void setKeys() throws NoSuchAlgorithmException {
        // 1.初始化发送方密钥
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        public_key= Base64.encodeBase64String(rsaPublicKey.getEncoded());
        private_key=Base64.encodeBase64String(rsaPrivateKey.getEncoded());
    }
    //私钥加密
    public String encrypt(String src) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(private_key));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(src.getBytes());
        return Base64.encodeBase64String(result);
    }
    //私钥解密
    public String decrypt(String target) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec5 = new PKCS8EncodedKeySpec(Base64.decodeBase64(private_key));
        KeyFactory keyFactory5 = KeyFactory.getInstance("RSA");
        PrivateKey privateKey5 = keyFactory5.generatePrivate(pkcs8EncodedKeySpec5);
        Cipher cipher5 = Cipher.getInstance("RSA");
        cipher5.init(Cipher.DECRYPT_MODE, privateKey5);
        byte[] result5 = cipher5.doFinal(Base64.decodeBase64(target));
        return new String(result5);
    }
}
