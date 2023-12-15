package com.ysh.common.util;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.digest.SM3;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.util.encoders.Hex;

/**
 * sm3加密算法
 *
 * @author likunming
 * @date 2023/12/01 11:27:26
 */
public class SM3Util {
    private final static byte[] salt = new byte[]{7,8,9,4,5,6};

    /**
     * 进行sm3加密
     *
     * @param param
     * @return
     */
    public static String encrypt(String param) {
        return new SM3(salt).digestHex(param);
    }

    /**
     * 校验密文是否相等
     *
     * @param encParam1 加密后的参数1
     * @param encParam2 加密后的参数2
     * @return 是否相等
     */
    public static boolean check(String encParam1, String encParam2) {
        return encParam1.equalsIgnoreCase(encParam2);
    }

    public static void main(String[] args) {
        String plaintext = "123";
        System.out.println(SmUtil.sm3(plaintext));

        byte[] md = new byte[32];
        byte[] msg = plaintext.getBytes();
        SM3Digest sm3Digest = new SM3Digest();
        sm3Digest.update(msg, 0, msg.length);
        sm3Digest.doFinal(md, 0);
        String s = new String(Hex.encode(md));
        System.out.println(s.toUpperCase());

        SM3 sm3 = new SM3(salt);
        System.out.println(sm3.digestHex(plaintext));
    }
}
