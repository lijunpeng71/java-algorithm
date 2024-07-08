package cn.com.bjtu.algorithm.base;

import java.util.Scanner;

public class MaxGap {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String linesStr = scanner.nextLine();
            String[] lines = linesStr.split(" ");
            String numsStr = scanner.nextLine();
            String[] nums = numsStr.split(" ");
            Long[] longNUms = new Long[nums.length];
            for (int i = 0; i < nums.length; i++) {
                longNUms[i] = Long.parseLong(nums[i]);
            }
            minGap(longNUms);
        } catch (Exception e) {
            System.exit(0);
        }
    }

    public static void minGap(Long[] nums) {
        
    }


    public static void quickSort(Long[] nums, int left, int right) {

    }
}
