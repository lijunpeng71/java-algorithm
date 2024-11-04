package cn.com.bjtu.citel.algorithm.io;

import java.util.Scanner;

public class MultiLineNumPlus {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String lineStr = scanner.nextLine();
                String[] nums = lineStr.split(" ");
                if ("0".equals(nums[0])) {
                    System.exit(0);
                }
                long sum = 0;
                for (String num : nums) {
                    sum += Integer.parseInt(num);
                }
                System.out.println(sum);
            }
        } catch (Exception e) {
            System.out.println("Bad input");
            System.err.println("程序发生异常，即将退出。");
        }
    }
}
