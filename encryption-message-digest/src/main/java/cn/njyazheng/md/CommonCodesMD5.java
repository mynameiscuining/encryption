package cn.njyazheng.md;

import org.apache.commons.codec.digest.DigestUtils;

public class CommonCodesMD5 {
    //加密
    public static String encrypt(String src)  {
        // 得到是十六进制的字符串
       return DigestUtils.md5Hex(src.getBytes());
    }
}
