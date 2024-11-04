package cn.com.bjtu.citel.algorithm.base;

import java.util.Scanner;

public class StringReflect {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] firstCharTimes = new int[26];
            int[] secondCharTimes = new int[26];
            String firstStr = scanner.nextLine();
            char[] firsts = firstStr.toCharArray();
            String secondStr = scanner.nextLine();
            char[] seconds = secondStr.toCharArray();
            for (int i = 0; i < firsts.length; ++i) {
                ++firstCharTimes[firsts[i] - 'A'];
                ++secondCharTimes[seconds[i] - 'A'];
            }
            quickSort(firstCharTimes, 0, firstCharTimes.length - 1);
            quickSort(secondCharTimes, 0, secondCharTimes.length - 1);
            boolean flag = true;
            for (int i = 0; i < firstCharTimes.length; ++i) {
                if (firstCharTimes[i] != secondCharTimes[i]) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
        } catch (Exception e) {
            System.exit(0);
        }
    }


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
}
