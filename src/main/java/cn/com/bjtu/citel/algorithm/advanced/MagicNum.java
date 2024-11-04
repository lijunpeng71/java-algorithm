package cn.com.bjtu.citel.algorithm.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MagicNum {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int batch = 1;
            while (true) {
                String xAndNStr = scanner.nextLine();
                int[] xAndN = Arrays.stream(xAndNStr.split(" ")).mapToInt(Integer::parseInt).toArray();
                int x = xAndN[0], N = xAndN[1];
                List<Integer[]> matchList = calcuate(x, N);
                if (matchList.isEmpty()) {
                    System.out.format("Case %d: No such numbers.\n", batch);
                } else {
                    System.out.format("Case %d:\n", batch);
                    matchList.forEach(matchs -> {
                        System.out.format("%d^%d+%d^%d+%d^%d=%d^%d\n", matchs[0], x, matchs[1], x, matchs[2], x, matchs[3],x);
                    });
                }
                batch++;
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }

    public static List<Integer[]> calcuate(int x, int N) {
        int[] numPowXs = new int[N + 1];
        for (int i = 1; i < numPowXs.length; i++) {
            numPowXs[i] = (int) Math.pow(i, x);
        }
        List<Integer[]> resultList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                for (int k = j; k <= N; k++) {
                    int sum = numPowXs[i] + numPowXs[j] + numPowXs[k];
                    for (int t = k + 1; t <= N; t++) {
                        if (numPowXs[t] > sum) {
                            break;
                        }
                        if (sum == numPowXs[t]) {
                            Integer[] matchs = new Integer[4];
                            matchs[0] = i;
                            matchs[1] = j;
                            matchs[2] = k;
                            matchs[3] = t;
                            resultList.add(matchs);
                            break;
                        }
                    }
                }
            }
        }
        return resultList;
    }
}
