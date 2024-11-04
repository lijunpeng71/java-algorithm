package cn.com.bjtu.citel.algorithm.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FantasticEquation {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int batch = 1;
            while (true) {
                int N = scanner.nextInt();
                List<List<Long>> matchList = calcuate(N);
                if (matchList.isEmpty()) {
                    System.out.format("Case %d:\n", batch);
                    System.out.println("    No such numbers");
                } else {
                    System.out.format("Case %d:\n", batch);
                    matchList.forEach(matchs -> System.out.format("    %d%d%d%d%d/%d%d%d%d%d=%d\n", matchs.get(0), matchs.get(1), matchs.get(2), matchs.get(3), matchs.get(4), matchs.get(5), matchs.get(6), matchs.get(7), matchs.get(8), matchs.get(9), N));
                }
                batch++;
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }

    private static List<List<Long>> calcuate(int N) {
        List<List<Long>> resultList = new ArrayList<>();
        long x;
        List<Long> numsList = null;
        for (long y = 99999 / N; y > 0; y--) {
            numsList = new ArrayList<>();
            x = y * N;
            //判断x
            long temp = x / 10000;
            numsList.add(temp);
            //第二位开始判断是否重复
            boolean isDuplicate = false;
            for (int i = 0; i <= 3; i++) {
                temp = x / ((int) Math.pow(10, 3 - i)) % 10;
                if (numsList.contains(temp)) {
                    isDuplicate = true;
                    break;
                }
                numsList.add(temp);
            }
            if (isDuplicate) {
                continue;
            }
            //判断y
            temp = y / 10000;
            if (numsList.contains(temp)) {
                continue;
            }
            numsList.add(temp);
            for (int i = 0; i <= 3; i++) {
                temp = y / ((int) Math.pow(10, 3 - i)) % 10;
                if (numsList.contains(temp)) {
                    isDuplicate = true;
                    break;
                }
                numsList.add(temp);
            }
            if (isDuplicate) {
                continue;
            }
            resultList.add(numsList);
        }
        return resultList;
    }
}
