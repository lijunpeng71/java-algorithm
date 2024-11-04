package cn.com.bjtu.citel.algorithm.advanced;

import java.util.Arrays;
import java.util.Scanner;

public class PeekDay {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int no = 1;
            while (true) {
                String periodStr = scanner.nextLine();
                int[] periods = Arrays.stream(periodStr.split(" ")).mapToInt(Integer::parseInt).toArray();
                int py = periods[0], iq = periods[1], eq = periods[2], lu = periods[3];
                String dayStr = scanner.nextLine();
                int[] days = Arrays.stream(dayStr.split(" ")).mapToInt(Integer::parseInt).toArray();
                int p = days[0], i = days[1], e = days[2], l = days[3], d = days[4];
                System.out.print("Case " + no++ + ": ");
                long maxDay = (long) py * iq * eq * lu + 1;
                boolean flag = false;
                for (int j = d + 1; j < maxDay; j++) {
                    if ((j - p) % py == 0 && (j - i) % iq == 0 && (j - e) % eq == 0 && (j - l) % lu == 0) {
                        flag = true;
                        System.out.println(j - d);
                        break;
                    }
                }
                if (!flag) {
                    System.out.println("No such days.");
                }
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
