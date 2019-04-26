package cn.njyazheng;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

//JDK
public class JDKBASE64 {
    //加密
    public static String encrypt(String src){
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(src.getBytes());
    }
    //解密
    public static String decrypt(String target ) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        return new String(decoder.decodeBuffer(target));
    }
}
