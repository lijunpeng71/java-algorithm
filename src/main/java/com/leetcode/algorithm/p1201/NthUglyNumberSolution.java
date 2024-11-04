package com.leetcode.algorithm.p1201;

public class NthUglyNumberSolution {

    public static int nthUglyNumber(int n, int a, int b, int c) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p_num_a = 1, p_num_b = 1, p_num_c = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = Math.min(Math.min(dp[p_num_a] * a, dp[p_num_b] * b), dp[p_num_c] * c);
            if (dp[i] == dp[p_num_a] * a) p_num_a++;
            if (dp[i] == dp[p_num_b] * b) p_num_b++;
            if (dp[i] == dp[p_num_c] * c) p_num_c++;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.format("%d\t", nthUglyNumber(i, 2, 11, 13));
        }
    }
}
