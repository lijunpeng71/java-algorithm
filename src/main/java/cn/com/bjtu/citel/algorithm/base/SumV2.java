package cn.com.bjtu.citel.algorithm.base;

import java.util.Scanner;

public class SumV2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String lineStr = scanner.nextLine();
                String[] lineNumsStr = lineStr.split(" ");
                long sum = 0;
                for (int i = 0; i < lineNumsStr.length; ++i) {
                    if (lineNumsStr[i].contains("0x")) {
                        lineNumsStr[i] = lineNumsStr[i].replace("0x", "");
                    }
                    sum += Long.parseLong(lineNumsStr[i], 16);
                }
                System.out.println(sum);
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
