package cn.com.bjtu.citel.algorithm.advanced;

import java.util.*;

public class ParallelProgram {

    private static List<List<String>> programsList = new ArrayList<>();
    //用于记录每个变量的值
    private static Map<String, Integer> valueMap = new HashMap<>();
    //循环队列
    private static Deque<Integer> waitQueue = new ArrayDeque<>();
    //阻塞队列
    private static Queue<Integer> blockQueue = new ArrayDeque<>();
    //七个指令的执行时间
    private static int[] times = new int[7];

    //程序数和最大时间片
    private static int n, Q;
    //是否加锁
    private static boolean locked;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String paramStr = scanner.nextLine();
            int[] params = Arrays.stream(paramStr.split(" ")).mapToInt(Integer::parseInt).toArray();
            n = params[0];
            Q = params[params.length - 1];
            programsList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<String> programs = new ArrayList<>();
                String code;
                do {
                    code = scanner.nextLine();
                    programs.add(code);
                } while (!"end".equals(code));
                programsList.add(programs);
            }
            for (int i = 1; i < params.length - 1; i++) {
                times[i - 1] = params[i];
            }
            for (int i = 0; i < programsList.size(); i++) {
                waitQueue.add(i);
            }
            //是否有锁标记
            boolean locked = false;
            while (!waitQueue.isEmpty()) {
                processProgram();
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }

    /**
     * 处理程序
     */
    private static void processProgram() {
        //当前执行的程序,并弹出
        int curIndex = waitQueue.poll();
        List<String> curProgram = programsList.get(curIndex);
        //花费时间
        int cost = 0;
        while (cost < Q && !curProgram.isEmpty()) {
            String curCodeStr = curProgram.get(0);
            if (curCodeStr.contains("+=")) {
                String[] curCodes = curCodeStr.split(" ");
                Integer value = valueMap.getOrDefault(curCodes[0], 0);
                //判断赋的值是否为变量
                if (checkIsNum(curCodes[2])) {
                    valueMap.put(curCodes[0], value + Integer.parseInt(curCodes[2]));
                } else {
                    valueMap.put(curCodes[0], value + valueMap.getOrDefault(curCodes[2], 0));
                }
                cost += times[1];
            } else if (curCodeStr.contains("-=")) {
                String[] curCodes = curCodeStr.split(" ");
                Integer value = valueMap.getOrDefault(curCodes[0], 0);
                if (checkIsNum(curCodes[2])) {
                    valueMap.put(curCodes[0], value - Integer.parseInt(curCodes[2]));
                } else {
                    valueMap.put(curCodes[0], value - valueMap.getOrDefault(curCodes[2], 0));
                }
                cost += times[2];
            } else if (curCodeStr.contains("=")) {
                String[] curCodes = curCodeStr.split(" ");
                if (checkIsNum(curCodes[2])) {
                    valueMap.put(curCodes[0], Integer.parseInt(curCodes[2]));
                } else {
                    valueMap.put(curCodes[0], valueMap.getOrDefault(curCodes[2], 0));
                }
                cost += times[0];
            } else if (curCodeStr.contains("print")) {
                String[] curCodes = curCodeStr.split(" ");
                Integer value = null;
                if (checkIsNum(curCodes[1])) {
                    value = Integer.parseInt(curCodes[1]);
                } else {
                    value = valueMap.getOrDefault(curCodes[1], 0);
                }
                System.out.println(curIndex + 1 + ": " + value);
                cost += times[3];
            } else if ("lock".equals(curCodeStr)) {
                if (locked) {
                    blockQueue.add(curIndex);
                    return;
                }
                locked = true;
                cost += times[4];
            } else if ("unlock".equals(curCodeStr)) {
                locked = false;
                if (!blockQueue.isEmpty()) {
                    waitQueue.addFirst(blockQueue.poll());
                }
                cost += times[5];
            } else {
                if ("end".equals(curCodeStr)) {
                    curProgram.remove(0);
                    return;
                }
            }
            curProgram.remove(0);
        }
        waitQueue.addLast(curIndex);
    }

    /**
     * 检验是否为数字
     */
    private static boolean checkIsNum(String testStr) {
        try {
            Integer.parseInt(testStr);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
