package cn.com.bjtu.citel.algorithm.base;

import java.util.Scanner;

public class Data2Format {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String linesStr = scanner.nextLine();
                String[] lines = linesStr.split("-");
                char[] yearChars = lines[0].toCharArray();
                if (yearChars.length < 4) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 4 - yearChars.length; ++i) {
                        sb.append("0");
                    }
                    sb.append("%s");
                    lines[0] = String.format(sb.toString(), lines[0]);
                }
                char[] monthChars = lines[1].toCharArray();
                if (monthChars.length == 1) {
                    lines[1] = String.format("0%c", monthChars[0]);
                }
                char[] dayChars = lines[2].toCharArray();
                if (dayChars.length == 1) {
                    lines[2] = String.format("0%c", dayChars[0]);
                }
                String newData = String.format("%s/%s/%s", lines[1], lines[2], lines[0]);
                System.out.println(newData);
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
