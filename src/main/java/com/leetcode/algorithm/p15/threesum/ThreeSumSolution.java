package com.leetcode.algorithm.p15.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSolution {


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int first = 0; first < len - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            int second = first + 1, third = len - 1;
            while (second < third) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    second++;
                    continue;
                }
                if (target - nums[second] > nums[third]) {
                    second++;
                } else if (target - nums[second] < nums[third]) {
                    third--;
                } else {
                    List<Integer> answer = new ArrayList<>();
                    answer.add(nums[first]);
                    answer.add(nums[second]);
                    answer.add(nums[third]);
                    answers.add(answer);
                    second++;
                    while (nums[second] == nums[second - 1]) {
                        second++;
                    }
                }
            }
        }
        return answers;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result.toString());
    }
}
