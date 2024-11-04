package cn.com.bjtu.citel.algorithm.io;

import java.util.Scanner;

public class NLineTwoNumPlus {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            long a, b;
            for (int i = 0; i < n; ++i) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                System.out.println(a + b);
            }
        } catch (Exception e) {
            System.out.println("Bad input");
            System.err.println("程序发生异常，即将退出。");
        }
    }
}
