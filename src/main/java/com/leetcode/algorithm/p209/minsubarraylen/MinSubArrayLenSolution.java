package com.leetcode.algorithm.p209.minsubarraylen;

public class MinSubArrayLenSolution {

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0, end = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int ret = minSubArrayLen(target, nums);
        System.out.println(ret);
    }
}
