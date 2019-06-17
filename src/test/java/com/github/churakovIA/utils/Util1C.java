package com.github.churakovIA.utils;

public class Util1C {
    public static String convertStringGUID(String str) {
        return str.substring(19, 23) +
                str.substring(24, 28) + "-" +
                str.substring(28, 32) + "-" +
                str.substring(32, 36) + "-" +
                str.substring(14, 19) +
                str.substring(9, 13) +
                str.substring(0, 8);
    }
}
