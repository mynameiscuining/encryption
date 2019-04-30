package cn.njyazheng.aes;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class JDKAES {
    //生成秘钥十六进制数组
    public static byte[] getKey() throws NoSuchAlgorithmException {
        // 获取KEY生成器
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        // 产生KEY
        SecretKey secretKey = keyGenerator.generateKey();
        // 获取KEY
        return secretKey.getEncoded();
    }

    //加密
    public static String encrypt(String src, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        // KEY转换
        //生成密钥
        Key convertSecretKey = convertSecretKey(key);

        // 加密
        //加解密算法：AES，工作方式：ECB，填充方式：PKCS5Padding
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        //第一个参数是模式：加密模式，KEY:转换后的KEY
        cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
        byte[] result = cipher.doFinal(src.getBytes());
        return Hex.encodeHexString(result);
    }
    public static Key convertSecretKey(byte[] key) {
        //生成密钥
        return new SecretKeySpec(key, "AES");
    }
    //解密
    public static String decrypt(String target,byte[]key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, DecoderException, BadPaddingException, IllegalBlockSizeException {
        // KEY转换
        //生成密钥
        Key convertSecretKey = convertSecretKey(key);

        //加解密算法：AES，工作方式：ECB，填充方式：PKCS5Padding
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
        byte[] result = cipher.doFinal(Hex.decodeHex(target));
        return new String(result);
    }
}
