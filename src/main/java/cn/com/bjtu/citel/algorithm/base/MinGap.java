package cn.com.bjtu.citel.algorithm.base;

import java.util.Scanner;

public class MinGap {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String linesStr = scanner.nextLine();
            String[] lines = linesStr.split(" ");
            int lineNum = Integer.parseInt(lines[0]);
            String numsStr = scanner.nextLine();
            String[] nums = numsStr.split(" ");
            long[] longNUms = new long[lineNum];
            for (int i = 0; i < lineNum; i++) {
                longNUms[i] = Long.parseLong(nums[i]);
            }
            long minGap = minGap(longNUms);
            System.out.println(minGap);
        } catch (Exception e) {
            System.exit(0);
        }
    }

    public static long minGap(long[] nums) {
        quickSort(nums, 0, nums.length - 1);
        long minGap = Long.MAX_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            long gap = nums[i] - nums[i - 1];
            if (minGap > gap) {
                minGap = gap;
            }
        }
        return minGap;
    }


    public static void quickSort(long[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int L = left, R = right;
        long pivot = nums[L];
        while (left < right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                long temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        nums[L] = nums[left];
        nums[left] = pivot;
        quickSort(nums, L, left - 1);
        quickSort(nums, right + 1, R);
    }
}
