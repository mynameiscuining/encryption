package cn.njyazheng.sha;

import org.apache.commons.codec.digest.DigestUtils;

public class CommonCodesSHA1 {
    //加密
    public static String encrypt(String src)  {
        // 得到是十六进制的字符串
        return DigestUtils.sha1Hex(src.getBytes());
    }
}
