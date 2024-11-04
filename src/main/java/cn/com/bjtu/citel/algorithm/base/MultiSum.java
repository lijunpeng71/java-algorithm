package cn.com.bjtu.citel.algorithm.base;

import java.util.Scanner;

public class MultiSum {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String lineStr = scanner.nextLine();
                String[] nums = lineStr.split(" ");
                long sum = 0;
                for (String num : nums) {
                    sum += Long.parseLong(num);
                }
                System.out.println(sum);
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
