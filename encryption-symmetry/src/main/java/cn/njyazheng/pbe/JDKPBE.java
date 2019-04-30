package cn.njyazheng.pbe;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

public class JDKPBE {

    //加密
    public static String encrypt(String src,String password, byte[] salt,int num) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        // KEY转换
        //生成密钥
        Key convertSecretKey = convertSecretKey(password);
        // 加密
        PBEParameterSpec pbeParameterSpac = new PBEParameterSpec(salt, num);//num为需要迭代的次数
        Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
        cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey,pbeParameterSpac);
        byte[] result = cipher.doFinal(src.getBytes());
        return Hex.encodeHexString(result);
    }

    /**
     *
     * @param
     * @return
     */
    public static byte[] getSalt() {
        SecureRandom random = new SecureRandom();//产生随机数
        //必须8个字节
        return random.generateSeed(8);
    }

    public static Key convertSecretKey(String password) throws  NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray()); //将口令转换为KEY
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");//实例化转换为KEY的工厂
        return factory.generateSecret(pbeKeySpec);
    }

    //解密
    public static String decrypt(String target,String password ,byte[] salt,int num) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, DecoderException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        // KEY转换

        Key convertSecretKey = convertSecretKey(password);
        PBEParameterSpec pbeParameterSpac = new PBEParameterSpec(salt, num);//num为需要迭代的次数
        Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
        cipher.init(Cipher.DECRYPT_MODE, convertSecretKey,pbeParameterSpac);
        byte[] result = cipher.doFinal(Hex.decodeHex(target));
        return new String(result);
    }
}
