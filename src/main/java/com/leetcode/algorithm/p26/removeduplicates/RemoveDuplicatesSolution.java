package com.leetcode.algorithm.p26.removeduplicates;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesSolution {


    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int orderIndex = 0, curIndex = 1, times = 0;
        while (orderIndex < len) {
            if (curIndex == len - 1) {
                if (times > 1) {
                    orderIndex++;
                    nums[++orderIndex] = nums[curIndex];
                } else {
                    nums[++orderIndex] = nums[curIndex];
                }
            }
            if (nums[orderIndex] == nums[curIndex]) {
                times++;
                curIndex++;
            } else {
                if (times > 1) {
                    orderIndex++;
                    nums[++orderIndex] = nums[curIndex];
                } else {
                    nums[++orderIndex] = nums[curIndex];
                }
            }
        }
        return orderIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = removeDuplicates(nums);
        System.out.println(k + 1);
    }
}
