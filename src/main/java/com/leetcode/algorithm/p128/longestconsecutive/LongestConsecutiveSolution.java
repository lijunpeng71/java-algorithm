package com.leetcode.algorithm.p128.longestconsecutive;

import java.util.Arrays;

/**
 * @author [您的名字]
 * @date 2024-08-19 11:50
 * @description [类的简要描述]
 */
public class LongestConsecutiveSolution {

    public static int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int index = 1;
        int maxLongest = 0;
        int longest = 0;
        while (index < nums.length) {
            if (nums[index] - nums[index - 1] == 1) {
                index++;
                longest++;
            } else if (nums[index] - nums[index - 1] == 0) {
                index++;
            } else {
                index++;
                maxLongest = Math.max(maxLongest, longest);
                longest = 0;
            }
            if (index == nums.length) {
                maxLongest = Math.max(maxLongest, longest) + 1;
            }
        }
        return maxLongest;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0,1};
        int longest = longestConsecutive(nums);
        System.out.println(longest);
    }
}
