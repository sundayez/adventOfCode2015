package com.bernar.adventofcode2015;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Day4 {
    public static void main(String[] args) {
        System.out.println(findLowestWithFiveZeros("abcdef"));
        System.out.println(findLowestWithFiveZeros("pqrstuv"));
        System.out.println(findLowestWithFiveZeros("bgvyzdsv"));
        System.out.println(findLowestWithSixZeros("abcdef"));
        System.out.println(findLowestWithSixZeros("pqrstuv"));
        System.out.println(findLowestWithSixZeros("bgvyzdsv"));

    }

    private static int findLowestWithFiveZeros(String input) {
        try {
            int i = 0;
            String result = "";
            do {
                result = encodeMd5(input + i);
                i++;
            } while (!result.startsWith("00000"));
            return i - 1;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static int findLowestWithSixZeros(String input) {
        try {
            int i = 0;
            String result = "";
            do {
                result = encodeMd5(input + i);
                i++;
            } while (!result.startsWith("000000"));
            return i - 1;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @NotNull
    private static String encodeMd5(String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] aa = messageDigest.digest(input.getBytes());
        BigInteger bigInt = new BigInteger(1, aa);
        StringBuilder hashtext = new StringBuilder(bigInt.toString(16));
        while (hashtext.length() < 32) {
            hashtext.insert(0, "0");
        }
        return hashtext.toString();
    }
}
