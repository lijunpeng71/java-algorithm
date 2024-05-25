package com.leetcode.algorithm.p28.strstr;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;

public class StrStrSolution {

    public static int[] next(String needle) {
        if (StrUtil.isBlank(needle)) {
            return null;
        }
        int n = needle.length();
        int[] pi = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        return pi;
    }

    public int strStr(String haystack, String needle) {
        return 0;
    }

    public static void main(String[] args) {
        int[] next = next("aabaaab");
        System.out.println(ArrayUtil.toString(next));
    }
}
