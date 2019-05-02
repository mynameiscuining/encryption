package cn.njyazheng.dsa;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.security.*;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class JDKDSA {
    
    private String public_key;
    private String private_key;
    
    public String getPublic_key() {
        return public_key;
    }
    
    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }
    
    public String getPrivate_key() {
        return private_key;
    }
    
    public void setPrivate_key(String private_key) {
        this.private_key = private_key;
    }
    
    public void setKeys() throws NoSuchAlgorithmException {// 1.初始化密钥
        
        KeyPairGenerator keyPairGenerator = KeyPairGenerator
                .getInstance("DSA");
        //设置密钥的长度
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //得到公钥
        DSAPublicKey dsaPublicKey = (DSAPublicKey) keyPair.getPublic();
        public_key= Base64.encodeBase64String(dsaPublicKey.getEncoded());
        //得到私钥
        DSAPrivateKey dsaPrivateKey = (DSAPrivateKey) keyPair.getPrivate();
        private_key=Base64.encodeBase64String(dsaPrivateKey.getEncoded());
    }
    
    //私钥签名
    public String signature(String src) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(private_key));
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        //声明签名的对象
        Signature signature = Signature.getInstance("SHA1withDSA");
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
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        //构造一个publicKey
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        //声明签名对象
        Signature signature = Signature.getInstance("SHA1withDSA");
        signature.initVerify(publicKey);
        signature.update(src.getBytes());
        //验证签名
        return signature.verify(Hex.decodeHex(target));
        
    }
}
