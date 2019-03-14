package com.bizvane.messageservice.common.network;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: lijunwei
 * @Time: 2018/7/17 13:57
 */
public class MD5Util {
    static char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public MD5Util() {
    }

    private static char char2Int(char ch) {
        if (ch >= '0' && ch <= '9') {
            return (char)(ch - 48);
        } else if (ch >= 'a' && ch <= 'f') {
            return (char)(ch - 97 + 10);
        } else {
            return ch >= 'A' && ch <= 'F' ? (char)(ch - 65 + 10) : ' ';
        }
    }

    private static byte str2Bin(char[] str) {
        char[] tempWord = new char[]{char2Int(str[0]), char2Int(str[1])};
        byte chn = (byte)(tempWord[0] << 4 | tempWord[1]);
        return chn;
    }

    public static byte[] compress(char[] md5chs32len) {
        char[] tem = new char[2];
        byte[] sDst = new byte[md5chs32len.length / 2];
        int j = 0;

        for(int i = 0; i + 1 < md5chs32len.length; i += 2) {
            tem[0] = md5chs32len[i];
            tem[1] = md5chs32len[i + 1];
            sDst[j++] = str2Bin(tem);
        }

        return sDst;
    }

    public static String unCompress(byte[] md5b16) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < md5b16.length; ++i) {
            byte b = md5b16[i];
            sb.append(Integer.toHexString(b >> 4 & 15));
            sb.append(Integer.toHexString(b & 15));
        }

        return sb.toString().toUpperCase();
    }

    public static byte[] getMD5Byte16(String text) {
        String md5 = getMD5Str32(text);
        return md5 != null ? compress(md5.toCharArray()) : null;
    }

    public static String getMD5Str32(String str) {
        if (str != null && !"".equals(str)) {
            MessageDigest messageDigest = null;

            try {
                messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes("UTF-8"));
            } catch (NoSuchAlgorithmException var3) {
                return null;
            } catch (UnsupportedEncodingException var4) {
                return null;
            }

            return byteToHexString(messageDigest.digest());
        } else {
            return null;
        }
    }

    private static String byteToHexString(byte[] tmp) {
        char[] str = new char[32];
        int k = 0;

        for(int i = 0; i < 16; ++i) {
            byte byte0 = tmp[i];
            str[k++] = hexDigits[byte0 >>> 4 & 15];
            str[k++] = hexDigits[byte0 & 15];
        }

        String s = new String(str);
        return s;
    }
}

