package cn.njyazheng.mac;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class JDKHMACMD5 {

    //获取秘钥字节数组
    public static byte[] getKey() throws NoSuchAlgorithmException {
        // 初始化KeyGenerator
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        // 产生密钥
        SecretKey secretKey = keyGenerator.generateKey();
        // 十六进制数组获取密钥
        return secretKey.getEncoded();
    }


    //加密
    public static String encrypt(String src,byte[]  key) throws InvalidKeyException, NoSuchAlgorithmException {
        // 还原密钥，HmacMD5是算法的名字
        SecretKey restoreSecretKey = new SecretKeySpec(key, "HmacMD5");
        // 实例化MAC
        Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
        // 初始化MAC
        mac.init(restoreSecretKey);
        // 执行消息摘要
        byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());
        return Hex.encodeHexString(hmacMD5Bytes);
    }
}
