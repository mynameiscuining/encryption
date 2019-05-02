package cn.njyazheng.rsa;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class JDKRSA {
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
        public_key = Base64.encodeBase64String(rsaPublicKey.getEncoded());
        private_key = Base64.encodeBase64String(rsaPrivateKey.getEncoded());
    }
    
    //私钥签名
    public String signature(String src) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(private_key));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        //声明签名的对象
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initSign(privateKey);
        signature.update(src.getBytes());
        //进行签名
        byte[] result = signature.sign();
        return Hex.encodeHexString(result);
    }
    
    //公钥认证解密
    public boolean auth(String src,String target) throws NoSuchAlgorithmException, InvalidKeySpecException, DecoderException, InvalidKeyException, SignatureException {
        //用公钥进行验证签名
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(public_key));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        //构造一个publicKey
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        //声明签名对象
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(publicKey);
        signature.update(src.getBytes());
        //验证签名
        return signature.verify(Hex.decodeHex(target));
        
    }
}
