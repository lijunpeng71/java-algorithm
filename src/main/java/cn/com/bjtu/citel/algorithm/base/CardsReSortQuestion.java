package cn.com.bjtu.citel.algorithm.base;

import java.util.Scanner;

public class CardsReSortQuestion {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int questNum = 1;
            while (true) {
                String lenAndQNum = scanner.nextLine();
                String cardsStr = scanner.nextLine();
                String questionStr = scanner.nextLine();
                System.out.format("Case #%d:\n", questNum++);
                process(lenAndQNum, cardsStr, questionStr);
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }

    /**
     * 处理方法
     *
     * @param lenAndQNum
     * @param cardsStr
     * @param questionStr
     * @return
     */
    private static void process(String lenAndQNum, String cardsStr, String questionStr) {
        String[] lenAndQNums = lenAndQNum.split(" ");
        int len = Integer.parseInt(lenAndQNums[0]);
        int qNum = Integer.parseInt(lenAndQNums[1]);
        String[] cardNums = cardsStr.split(" ");
        long[] longCardNums = new long[len];
        for (int i = 0; i < cardNums.length; ++i) {
            longCardNums[i] = Long.parseLong(cardNums[i]);
        }
        quickSort(longCardNums, 0, longCardNums.length - 1);
        String[] questions = questionStr.split(" ");
        for (int i = 0; i < qNum; ++i) {
            long question = Long.parseLong(questions[i]);
            int index = binarySearch(longCardNums, 0, longCardNums.length - 1, question);
            System.out.format(index == -1 ? "%d not found" : "%d found at %d", question, index + 1);
            System.out.println();
        }
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

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(long[] nums, int left, int right, long target) {
        if (left > right) {
            return -1;
        }
        int mid = left + ((right - left) >> 1);
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, left, mid - 1, target);
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        } else {
            return -1;
        }
    }
}
