package cn.com.bjtu.citel.algorithm.advanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lift2V1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int no = 1;
            while (true) {
                String paramStr = scanner.nextLine();
                int[] params = Arrays.stream(paramStr.split(" ")).mapToInt(Integer::parseInt).toArray();
                String levelStr = scanner.nextLine();
                int cost = processLift(params, levelStr);
                System.out.format("Case " + no++ + ": " + cost);
                System.out.println();
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }

    /**
     * 处理流程
     *
     * @param params：输入参数
     * @param levels:     from-to
     * @return int
     */
    private static int processLift(int[] params, String levels) {
        //大顶堆
        PriorityQueue<Integer> que1 = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> que3 = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> que5 = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> que7 = new PriorityQueue<>(Comparator.reverseOrder());
        //小顶堆
        PriorityQueue<Integer> que2 = new PriorityQueue<>();
        PriorityQueue<Integer> que4 = new PriorityQueue<>();
        PriorityQueue<Integer> que6 = new PriorityQueue<>();
        PriorityQueue<Integer> que8 = new PriorityQueue<>();
        int up_from_min1 = 205, up_from_min2 = 205, down_from_max1 = -1, down_from_max2 = -1;
        int from, to;
        int n = params[0], u = params[1], d = params[2], s = params[3];
        String[] fromToStrs = levels.split(" ");
        for (String fromToStr : fromToStrs) {
            int[] fromTos = Arrays.stream(fromToStr.split("-")).mapToInt(Integer::parseInt).toArray();
            from = fromTos[0];
            to = fromTos[1];
            if (to > from) {
                if (from >= n) {
                    que1.add(to);
                }
                if (from >= n) {
                    que1.add(from);
                }
                if (from < n) {
                    que3.add(to);
                }
                if (from < n) {
                    que3.add(from);
                }
                if (from <= n) {
                    up_from_min1 = Math.min(up_from_min1, from);
                }
                if (from < n) {
                    up_from_min2 = Math.min(up_from_min2, from);
                }
            } else {
                if (from <= n) {
                    que2.add(to);
                }
                if (from <= n) {
                    que2.add(from);
                }
                if (from > n) {
                    que4.add(to);
                }
                if (from > n) {
                    que4.add(from);
                }
                if (from >= n) {
                    down_from_max1 = Math.max(down_from_max1, from);
                }
                if (from > n) {
                    down_from_max2 = Math.max(down_from_max2, from);
                }
            }
        }
        int time1 = 0, time2 = 0;
        int step1 = n, step2 = n;
        if (!que1.isEmpty()) {
            time1 += u * (que1.peek() - n);
            step1 = que1.peek();
        }
        while (!que1.isEmpty()) {
            int x = que1.peek();
            que5.add(x);
            if (x != n) {
                time1 += s;
            }
            while (!que1.isEmpty() && que1.peek() == x) {
                que1.poll();
            }
        }
        if (down_from_max1 != -1 && down_from_max1 > step1) {
            time1 += u * (down_from_max1 - step1) + s;
            step1 = down_from_max1;
        }
        int step3 = step1;
        if (!que2.isEmpty()) {
            time1 += d * (step3 - que2.peek());
            time2 += d * (n - que2.peek());
            step2 = que2.peek();
            step3 = que2.peek();
        }
        while (!que2.isEmpty()) {
            int x = que2.peek();
            que6.add(x);
            if (x != n) {
                time2 += s;
            }
            while (!que2.isEmpty() && que2.peek() == x) {
                que2.poll();
            }
        }
        if (up_from_min1 != 205 && up_from_min1 < step2) {
            time2 += d * (step2 - up_from_min1) + s;
            step2 = up_from_min1;
        }
        que2.addAll(que6.parallelStream().collect(Collectors.toList()));
        int step4 = step2;
        if (!que4.isEmpty() && step3 > que4.peek()) {
            time1 += d * (step3 - que4.peek());
            step3 = que4.peek();
        }
        que8.addAll(que4.parallelStream().collect(Collectors.toList()));
        while (!que4.isEmpty()) {
            que2.add(que4.peek());
            que4.poll();
        }
        while (!que2.isEmpty()) {
            int x = que2.peek();
            if (x != step1) {
                time1 += s;
            }
            while (!que2.isEmpty() && que2.peek() == x) {
                que2.poll();
            }
        }
        if (up_from_min2 != 205 && step3 > up_from_min2) {
            time1 += d * (step3 - up_from_min2) + s;
            step3 = up_from_min2;
        }
        if (!que3.isEmpty()) {
            time1 += u * (que3.peek() - step3);
        }
        while (!que3.isEmpty()) {
            int x = que3.peek();
            que7.add(x);
            if (x != step3) {
                time1 += s;
            }
            while (!que3.isEmpty() && que3.peek() == x) {
                que3.poll();
            }
        }
        while (!que5.isEmpty()) {
            que7.add(que5.peek());
            que5.poll();
        }
        if (!que7.isEmpty()) {
            step4 = que7.peek();
        }
        time2 += u * (step4 - step2);
        while (!que7.isEmpty()) {
            int x = que7.peek();
            if (x != step2) {
                time2 += s;
            }
            while (!que7.isEmpty() && que7.peek() == x) {
                que7.poll();
            }
        }
        if (down_from_max2 != -1 && down_from_max2 > step4) {
            time2 += u * (down_from_max2 - step4) + s;
            step4 = down_from_max2;
        }
        if (!que8.isEmpty()) {
            time2 += d * (step4 - que8.peek());
        }
        while (!que8.isEmpty()) {
            int x = que8.peek();
            if (x != step4) {
                time2 += s;
            }
            while (!que8.isEmpty() && que8.peek() == x) {
                que8.poll();
            }
        }
        return Math.min(time1, time2);
    }
}
