package cn.com.bjtu.citel.algorithm.base;

import java.util.Scanner;

public class UglyNumber {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String numsStr = scanner.nextLine();
                String[] nums = numsStr.split(" ");
                long uglyNumber = getUglyNumber(Integer.parseInt(nums[0]));
                System.out.println(uglyNumber);
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }

    /**
     * 获取ugly
     *
     * @param n
     * @return
     */
    public static long getUglyNumber(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        int p_num2 = 1, p_num3 = 1, p_num5 = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = Math.min(Math.min(dp[p_num2] * 2, dp[p_num3] * 3), dp[p_num5] * 5);
            if (dp[i] == dp[p_num2] * 2) p_num2++;
            if (dp[i] == dp[p_num3] * 3) p_num3++;
            if (dp[i] == dp[p_num5] * 5) p_num5++;
        }
        return dp[n];
    }
}

