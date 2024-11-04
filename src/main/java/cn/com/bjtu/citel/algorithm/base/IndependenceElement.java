package cn.com.bjtu.citel.algorithm.base;

import java.util.Scanner;

public class IndependenceElement {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String lenStr = scanner.nextLine();
            String[] lines = lenStr.split(" ");
            int len = Integer.parseInt(lines[0]);
            String numsStr = scanner.nextLine();
            String[] nums = numsStr.split(" ");
            long[] longNums = new long[len];
            for (int i = 0; i < len; i++) {
                longNums[i] = Long.parseLong(nums[i]);
            }
            quickSort(longNums, 0, longNums.length - 1);
            int index = 1;
            System.out.print(longNums[index - 1]);
            while (index < longNums.length) {
                if (longNums[index - 1] != longNums[index]) {
                    System.out.format(" %d", longNums[index]);
                }
                index++;
            }
            System.out.println();
        } catch (Exception e) {
            System.exit(0);
        }
    }

    /**
     * 快排（按照从大到小顺序）
     *
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort(long[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int L = left, R = right;
        long pivot = nums[L];
        while (left < right) {
            while (left < right && nums[right] < pivot) {
                right--;
            }
            while (left < right && nums[left] >= pivot) {
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
