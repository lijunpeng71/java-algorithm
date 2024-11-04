package cn.com.bjtu.citel.algorithm.advanced;

import java.util.Arrays;
import java.util.Scanner;

public class SubString {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String lineStr = scanner.nextLine();
            char[] chars = lineStr.toCharArray();
            int batch = 1;
            while (true) {
                String splitNumStr = scanner.nextLine();
                int splitNum = Arrays.stream(splitNumStr.split(" ")).mapToInt(Integer::parseInt).toArray()[0];
                System.out.format("Case %d:\n", batch);
                for (int i = 1; i <= splitNum; i++) {
                    for (int j = 0; j < i; j++) {
                        System.out.print(chars[j]);
                    }
                    System.out.print(" ");
                    for (int j = i; j < chars.length; j += splitNum) {
                        for (int k = j; k < chars.length && k < j + splitNum; k++) {
                            System.out.print(chars[k]);
                        }
                        if (j + splitNum < chars.length) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                batch++;
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
