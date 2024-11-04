package cn.com.bjtu.citel.algorithm.io;

import java.util.Scanner;

public class MultiNNumPlus {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                int num = scanner.nextInt();
                if (num == 0) {
                    System.exit(0);
                }
                long sum = 0;
                for (int i = 0; i < num; i++) {
                    sum += scanner.nextInt();
                }
                System.out.println(sum);
            }
        } catch (Exception e) {
            System.out.println("Bad input");
            System.err.println("程序发生异常，即将退出。");
        }
    }
}
