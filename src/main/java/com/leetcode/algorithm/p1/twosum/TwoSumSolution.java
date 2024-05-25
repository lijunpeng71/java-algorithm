package com.leetcode.algorithm.p1.twosum;

import cn.hutool.core.util.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = numsMap.get(target - nums[i]);
            if (index == null) {
                numsMap.put(nums[i], i);
            } else {
                return new int[]{index, i};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 17;
        int[] result = twoSum(nums, target);
        System.out.println(ArrayUtil.toString(result));
    }
}
