package com.ab.apitest.utils;

import java.security.SecureRandom;

public class Utils {

    private static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String numbers = "0123456789";
    private static final String alphaNumeric = letters + numbers;
    private static final SecureRandom rnd = new SecureRandom();

    public static boolean isValidLength(int length) {
        return length >= 1 && length <= 255;
    }

    public static String generateRandomAlphanumericString(int length) {
        StringBuilder sb = new StringBuilder(length);
        if(isValidLength(length)) {
            sb.append("Auto");
        }
        for(int i = 0; i < length; i++)
            sb.append(alphaNumeric.charAt(rnd.nextInt(alphaNumeric.length())));
        return sb.toString();
    }

    public static String generateRandomNumericString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for(int i = 0; i < length; i++)
            sb.append(numbers.charAt(rnd.nextInt(numbers.length())));
        return sb.toString();
    }
}
