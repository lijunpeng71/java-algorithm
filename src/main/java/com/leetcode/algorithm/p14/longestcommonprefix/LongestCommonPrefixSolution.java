package com.leetcode.algorithm.p14.longestcommonprefix;

public class LongestCommonPrefixSolution {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }
        int len = strs.length;
        if (len == 1) {
            return strs[0];
        }
        StringBuilder common = new StringBuilder();
        int i = 0;
        while (i < strs[0].length()) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < len; j++) {
                int strLen = strs[j].length();
                if (strLen == i || ch != strs[j].charAt(i)) {
                    return common.toString();
                }
            }
            common.append(ch);
            i++;
        }
        return common.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flower", "flower", "flower"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
}
