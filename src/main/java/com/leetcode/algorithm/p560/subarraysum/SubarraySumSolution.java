package com.leetcode.algorithm.p560.subarraysum;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 *
 * @author [您的名字]
 * @date 2024-09-14 12:56
 * @description [类的简要描述]
 */
public class SubarraySumSolution {

    /**
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum01(int[] nums, int k) {
        int total = 0;
        for (int left = 0; left < nums.length; left++) {
            int sum = 0, right = left;
            while (right < nums.length) {
                sum += nums[right++];
                if (sum == k) {
                    ++total;
                }
            }
        }
        return total;
    }

    public static int subarraySum02(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int sum : prefixSums) {
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


    public static int subarraySum03(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> preSumTimesMap = new HashMap<>();
        //前缀和为0的次数默认为1次
        preSumTimesMap.put(0, 1);
        int all = 0;
        int ans = 0;
        for (int num : nums) {
            all += num;
            if (preSumTimesMap.containsKey(all - k)) {
                ans += preSumTimesMap.get(all - k);
            }
            if (!preSumTimesMap.containsKey(all)) {
                preSumTimesMap.put(all, 1);
            } else {
                preSumTimesMap.put(all, preSumTimesMap.get(all) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        int ret = subarraySum03(nums, k);
        System.out.println(ret);
    }
}
