package cn.com.bjtu.citel.algorithm.io;

import java.util.Scanner;

public class NMultiNNumPlus {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            long line = scanner.nextLong();
            boolean flag = false;
            for (long i = 0; i < line; ++i) {
                long num = scanner.nextLong();
                long sum = 0, temp;
                for (int j = 0; j < num; ++j) {
                    temp = scanner.nextLong();
                    sum += temp;
                }
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
