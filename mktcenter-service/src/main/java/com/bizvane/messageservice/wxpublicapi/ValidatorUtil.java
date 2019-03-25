package com.bizvane.messageservice.wxpublicapi;

/**
 * Created by admin on 2016/7/6.
 */
public class ValidatorUtil {
    public static boolean isNull(String s) {
        if (s == null) {
            return true;
        }

        s = s.trim();
        return (s.equalsIgnoreCase("null")) || (s.equals(""));

    }

    public static boolean isNotNull(String s) {
        return !isNull(s);
    }


    public static boolean isNumber(String number) {
        if (isNull(number)) {
            return false;
        }

        char[] c = number.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (!isDigit(c[i])) {
                return false;
            }
        }

        return true;
    }


    public static boolean isDigit(char c) {
        int x = (int)c;

        return ((x >= 48) && (x <= 57));

    }
}
