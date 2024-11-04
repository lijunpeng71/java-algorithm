package cn.com.bjtu.citel.algorithm.io;

import java.util.Scanner;

public class MultiTwoNumPlus {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                long a = scanner.nextInt();
                long b = scanner.nextInt();
                if (a == 0 && b == 0) {
                    System.exit(0);
                } else {
                    System.out.println(a + b);
                }
            }
        } catch (Exception e) {
            System.out.println("Bad input");
            System.err.println("程序发生异常，即将退出。");
        }
    }
}
