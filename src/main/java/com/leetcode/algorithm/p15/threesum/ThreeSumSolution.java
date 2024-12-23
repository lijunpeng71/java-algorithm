package com.leetcode.algorithm.p15.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSolution {


    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> answers = new ArrayList<>();

        for (int first = 0; first < n; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> answer = new ArrayList<>();
                    answer.add(nums[first]);
                    answer.add(nums[second]);
                    answer.add(nums[third]);
                    answers.add(answer);
                }
            }
        }
        return answers;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }
}
