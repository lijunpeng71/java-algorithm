package cn.com.bjtu.citel.algorithm.advanced;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringReflectV2 {
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
            int[] oldFirstCharTimes = firstCharTimes.clone();
            int[] oldSecondCharTimes = secondCharTimes.clone();
            quickSort(firstCharTimes, 0, firstCharTimes.length - 1);
            quickSort(secondCharTimes, 0, secondCharTimes.length - 1);
            boolean flag = true;
            for (int i = 0; i < firstCharTimes.length; ++i) {
                if (firstCharTimes[i] != secondCharTimes[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("YES");
                Set<Character> firstVisitedSet = new HashSet<>();
                Set<Character> secondVisitedSet = new HashSet<>();
                for (int i = 0; i < firsts.length; i++) {
                    if (firstVisitedSet.contains(firsts[i])) {
                        continue;
                    }
                    int firstCharIndex = firsts[i] - 'A';
                    for (int j = 0; j < seconds.length; j++) {
                        if (secondVisitedSet.contains(seconds[j])) {
                            continue;
                        }
                        int secondCharIndex = seconds[j] - 'A';
                        if (oldFirstCharTimes[firstCharIndex] == oldSecondCharTimes[secondCharIndex]) {
                            //在最后一个之前，第一个串的字符大于第二个串的字符
                            if(i==0) {
                                System.out.format("%c->%c", firstCharIndex + 'A', secondCharIndex + 'A');
                            }else{
                                System.out.format(" %c->%c", firstCharIndex + 'A', secondCharIndex + 'A');
                            }
                            firstVisitedSet.add(firsts[i]);
                            secondVisitedSet.add(seconds[j]);
                            break;
                        }
                    }
                }
                System.out.println();
            } else {
                System.out.println("NO");
            }
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
