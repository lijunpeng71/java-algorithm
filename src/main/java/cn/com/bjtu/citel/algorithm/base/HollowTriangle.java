package cn.com.bjtu.citel.algorithm.base;

import java.util.Scanner;

public class HollowTriangle {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String asciiStr = scanner.next();
            char asciiCh = asciiStr.charAt(0);
            int n = scanner.nextInt();
            int max = n * 2 - 1;
            //第1行
            for (int i = 1; i <= n; i++) {
                if (i != n) {
                    System.out.print(" ");
                } else {
                    System.out.print(asciiCh);
                }
            }
            System.out.println();
            //第2行到n-1行
            for (int i = 2; i <= n - 1; i++) {
                for (int j = 1; j <= n + i; j++) {
                    if (j == n - i + 1 || j == n + i - 1) {
                        System.out.print(asciiCh);
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            //最后一行
            for (int i = 1; i <= max; i++) {
                if (i % 2 == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(asciiCh);
                }
            }
            System.out.println();
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
