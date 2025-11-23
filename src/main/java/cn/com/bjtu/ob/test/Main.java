package cn.com.bjtu.ob.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; ++i) {
            String numAStr = scanner.next();
            String numBStr = scanner.next();

            // 获取字符串的最后一个字符
            char c = numAStr.charAt(numAStr.length() - 1);
            char d = numBStr.charAt(numBStr.length() - 1);

            // 判断是否属于必败情况
            if ((c == '2' || c == '3' || c == '7' || c == '8') &&
                    (d == '2' || d == '3' || d == '7' || d == '8')) {
                System.out.println("Shadow");
            } else {
                System.out.println("Matrix67");
            }
        }
        scanner.close();
    }
}