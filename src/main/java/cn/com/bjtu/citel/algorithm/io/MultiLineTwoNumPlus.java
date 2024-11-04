package cn.com.bjtu.citel.algorithm.io;

import java.util.Scanner;

public class MultiLineTwoNumPlus {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean flag = false;
            while (true) {
                String numStr = scanner.nextLine();
                String[] nums = numStr.split(" ");
                long sum = Long.parseLong(nums[0]) + Long.parseLong(nums[1]);
                if (flag) {
                    System.out.println();
                }
                System.out.println(sum);
                flag = true;
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}