package com.leetcode.algorithm.p283.movezeroes;

import cn.hutool.core.util.ArrayUtil;

/**
 * @author [您的名字]
 * @date 2024-08-19 12:47
 * @description [类的简要描述]
 */
public class MoveZeroesSolution {

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int zeroIndex = 0;
        int currIndex = 0;
        while (currIndex < nums.length) {
            //找到为零的元素
            while (currIndex < nums.length && nums[currIndex] != 0) {
                currIndex++;
            }
            zeroIndex = currIndex;
            while (currIndex < nums.length && nums[currIndex] == 0) {
                currIndex++;
            }
            if (zeroIndex < nums.length && currIndex < nums.length) {
                //交互位置
                int temp = nums[zeroIndex];
                nums[zeroIndex] = nums[currIndex];
                nums[currIndex] = temp;
                currIndex = zeroIndex;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(ArrayUtil.toString(nums));
    }
}
