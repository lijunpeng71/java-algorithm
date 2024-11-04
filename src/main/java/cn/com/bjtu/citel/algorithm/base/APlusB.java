package cn.com.bjtu.citel.algorithm.base;

import java.math.BigDecimal;
import java.util.Scanner;

public class APlusB {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String linesStr = scanner.nextLine();
                String[] lines = linesStr.split(" ");
                BigDecimal a = new BigDecimal(lines[0]);
                BigDecimal b = new BigDecimal(lines[1]);
                BigDecimal result = a.add(b);
                System.out.println(result.toString());
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
