package com.bernar.adventofcode2015;

public class Day1 {
    public static void main(String[] args) {
        String content = FileInput.getInstance().readStringFromFile("input1.txt").get(0);

        System.out.println(finalFloor(content));
        System.out.println(firstBasement(content));
    }

    private static int finalFloor(String content) {
        int count = 0;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
        }
        return count;
    }

    private static int firstBasement(String content) {
        int count = 0;
        int i;
        for (i = 0; i < content.length() && count != -1; i++) {
            if (content.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
        }
        return i;
    }
}
