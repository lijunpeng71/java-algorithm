package com.leetcode.algorithm.p239.maxslidingwindow;

import cn.hutool.core.util.ArrayUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * @author [您的名字]
 * @date 2024-09-24 23:45
 * @description :
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 */
public class MaxSlidingWindowSolution {


    /**
     * 双层循环，运行超时
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow01(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] rets = new int[nums.length - k + 1];
        for (int i = k; i <= nums.length; i++) {
            int max = nums[i - 1];
            for (int j = i - k; j < i; j++) {
                max = Math.max(max, nums[j]);
            }
            rets[i - k] = max;
        }
        return rets;
    }


    public static int[] maxSlidingWindow02(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return null;
        }
        //其中方的是位置索引，头代表（大->小）
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] rets = new int[nums.length - k + 1];
        int index = 0;
        for (int R = 0; R < nums.length; R++) {
            while (!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[R]) {
                qMax.pollLast();
            }
            qMax.addLast(R);
            if (qMax.peekFirst() == R - k) {
                qMax.pollFirst();
            }
            if (R >= k - 1) {
                rets[index++] = nums[qMax.peekFirst()];
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] rets = maxSlidingWindow02(nums, k);
        System.out.println(ArrayUtil.toString(rets));
    }
}
