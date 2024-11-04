package com.mashibing.zuoshen.algorithm;

import cn.hutool.core.util.ArrayUtil;

public class QuickSort {


    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int L = left, R = right;
        int pivot = nums[L];
        while (left < right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        nums[L] = nums[left];
        nums[left] = pivot;
        quickSort(nums, L, left - 1);
        quickSort(nums, right + 1, R);
    }

    public static void main(String[] args) {
        int[] nums = {6, 7, 4, 9, 5, 8, 3, 1, 2, 0};
        System.out.println(ArrayUtil.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println(ArrayUtil.toString(nums));
    }
}
