package com.leetcode.algorithm.p125.ispalindrome;

public class IsPalindromeSolution {


    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            char startCh = s.charAt(start);
            char endCh = s.charAt(end);
            if (!illegal(startCh)) {
                start++;
                continue;
            }
            if (!illegal(endCh)) {
                end--;
                continue;
            }
            if (startCh != endCh) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean illegal(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return true;
        } else if (ch >= '0' && ch <= '9') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "race a car";
        boolean palindrome = isPalindrome(str);
        System.out.println(palindrome);
    }
}
