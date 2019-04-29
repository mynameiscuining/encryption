package cn.njyazheng.desede;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

public class BouncyCastle3DES {
    //生成秘钥十六进制数组
    public static byte[] getKey() throws NoSuchProviderException, NoSuchAlgorithmException {
        Security.addProvider(new BouncyCastleProvider());
        // 获取KEY生成器
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede", "BC");
        keyGenerator.getProvider();
        keyGenerator.init(168);
        // 产生KEY
        SecretKey secretKey = keyGenerator.generateKey();
        // 获取KEY
        return  secretKey.getEncoded();
    }

    //加密
    public static String encrypt(String src, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        // KEY转换
        //生成密钥
        Key convertSecretKey = convertSecretKey(key);
        // 加密
        //加解密算法：DES，工作方式：ECB，填充方式：PKCS5Padding
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        //第一个参数是模式：加密模式，KEY:转换后的KEY
        cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
        byte[] result = cipher.doFinal(src.getBytes());
        return Hex.encodeHexString(result);
    }
    public static Key convertSecretKey(byte[] key) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {
        // KEY转换
        DESedeKeySpec desKeySpec = new DESedeKeySpec(key);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");//getInstance()参数指定的加密方式
        return factory.generateSecret(desKeySpec);//生成密钥
    }
    //解密
    public static String decrypt(String target,byte[]key) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, DecoderException, BadPaddingException, IllegalBlockSizeException, DecoderException {
        // KEY转换
        //生成密钥
        Key convertSecretKey = convertSecretKey(key);
        //加解密算法：DES，工作方式：ECB，填充方式：PKCS5Padding
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
        byte[] result = cipher.doFinal(Hex.decodeHex(target));
        return new String(result);
    }
}
