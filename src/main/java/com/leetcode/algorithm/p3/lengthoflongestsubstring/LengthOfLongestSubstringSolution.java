package com.leetcode.algorithm.p3.lengthoflongestsubstring;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstringSolution {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> occ = new HashSet<>();
        int ans = 0, left = 0, right = 0;
        for (left = 0; left < s.length(); left++) {
            if (left != 0) {
                occ.remove(s.charAt(left - 1));
            }
            while (right < s.length() && !occ.contains(s.charAt(right))) {
                occ.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int len = lengthOfLongestSubstring(s);
        System.out.println(len);
    }
}
