package cn.com.bjtu.citel.algorithm.advanced;

import java.util.Arrays;
import java.util.Scanner;

public class Multiply {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int batch = 1;
            while (true) {
                String lineStr = scanner.nextLine();
                long[] nums = Arrays.stream(lineStr.split(" ")).mapToLong(Long::parseLong).toArray();
                int minFrom = 0, minTo = 0;
                long maxValue = nums[0];
                for (int from = 0; from < nums.length; from++) {
                    long mulValue = 1;
                    for (int to = from; to < nums.length; to++) {
                        mulValue *= nums[to];
                        if (mulValue > maxValue || (mulValue == maxValue && (minTo - minFrom) > (to - from))) {
                            minFrom = from;
                            minTo = to;
                            maxValue = mulValue;
                        } else if (mulValue == maxValue && (minTo - minFrom) == (to - from)) {
                            if (from < minFrom) {
                                minFrom = from;
                                minTo = to;
                            }
                        }
                    }
                }
                System.out.println("Case " + batch + ": " + maxValue + " " + minFrom + "-" + minTo);
                batch++;
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
