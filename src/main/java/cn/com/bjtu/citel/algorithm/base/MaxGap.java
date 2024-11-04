package cn.com.bjtu.citel.algorithm.base;

import java.util.Scanner;

public class MaxGap {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String linesStr = scanner.nextLine();
            String[] lines = linesStr.split(" ");
            String numsStr = scanner.nextLine();
            String[] nums = numsStr.split(" ");
            long max = Long.MAX_VALUE, min = Long.MIN_VALUE;
            for (int i = 0; i < Integer.parseInt(lines[0]); i++) {
                long temp = Long.parseLong(nums[i]);
                if (temp < max) {
                    max = temp;
                }
                if (temp > min) {
                    min = temp;
                }
            }
            System.out.println(max - min);
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
