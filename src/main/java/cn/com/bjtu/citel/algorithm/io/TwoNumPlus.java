package cn.com.bjtu.citel.algorithm.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TwoNumPlus {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                try {
                    long a = scanner.nextInt();
                    long b = scanner.nextInt();
                    System.out.println(a + b);
                } catch (InputMismatchException e) {
                    System.out.println("Bad input");
                    scanner.next();
                }
            }
        } catch (Exception e) {
            System.out.println("Bad input");
            System.err.println("程序发生异常，即将退出。");
        }
    }
}
