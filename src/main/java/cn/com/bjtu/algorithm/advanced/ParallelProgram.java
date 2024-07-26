package cn.com.bjtu.algorithm.advanced;

import java.util.*;

public class ParallelProgram {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String paramStr = scanner.nextLine();
            int[] times = Arrays.stream(paramStr.split(" ")).mapToInt(Integer::parseInt).toArray();
            List<List<String>> programsList = new ArrayList<>();
            for (int i = 0; i < times[0]; i++) {
                List<String> programs = new ArrayList<>();
                String code;
                do {
                    code = scanner.nextLine();
                    programs.add(code);
                } while (!"end".equals(code));
                programsList.add(programs);
            }
            processProgram(times, programsList);
        } catch (Exception e) {
            System.exit(0);
        }
    }

    /**
     * 处理程序
     *
     * @param params
     * @param programsList
     */
    private static void processProgram(int[] params, List<List<String>> programsList) {
        //用于记录每个指令花费的时间
        int[] times = new int[7];
        for (int i = 1; i < params.length - 1; i++) {
            times[i - 1] = params[i];
        }
        int maxTime = params[params.length - 1];
        //用于记录每个变量的值
        Map<String, Integer> valueMap = new HashMap<>();
        //阻塞队列
        Queue<Integer> blockQueue = new ArrayDeque<>();
        //已经完成的程序数
        int finishNum = 0;
        //当前执行的程序
        int curIndex = 0;
        //是否有锁标记
        boolean locked = false;
        while (finishNum < programsList.size()) {
            List<String> curPrograms = programsList.get(curIndex);
            //花费时间
            int cost = 0;
            while (cost < maxTime && !curPrograms.isEmpty()) {
                String curCodeStr = curPrograms.get(0);
                boolean canVisitValue = !locked || Objects.equals(blockQueue.peek(), curIndex);
                if (curCodeStr.contains("+=") && canVisitValue) {
                    String[] curCodes = curCodeStr.split(" ");
                    Integer value = valueMap.putIfAbsent(curCodes[0], 0);
                    //判断赋的值是否为变量
                    if (checkIsNum(curCodes[2])) {
                        valueMap.put(curCodes[0], value + Integer.parseInt(curCodes[2]));
                    } else {
                        valueMap.put(curCodes[0], value + valueMap.getOrDefault(curCodes[2], 0));
                    }
                    cost += times[1];
                    curPrograms.remove(0);
                } else if (curCodeStr.contains("-=") && canVisitValue) {
                    String[] curCodes = curCodeStr.split(" ");
                    Integer value = valueMap.putIfAbsent(curCodes[0], 0);
                    if (checkIsNum(curCodes[2])) {
                        valueMap.put(curCodes[0], value - Integer.parseInt(curCodes[2]));
                    } else {
                        valueMap.put(curCodes[0], value - valueMap.getOrDefault(curCodes[2], 0));
                    }
                    cost += times[2];
                    curPrograms.remove(0);
                } else if (curCodeStr.contains("=") && canVisitValue) {
                    String[] curCodes = curCodeStr.split(" ");
                    if (checkIsNum(curCodes[2])) {
                        valueMap.put(curCodes[0], Integer.parseInt(curCodes[2]));
                    } else {
                        valueMap.put(curCodes[0], valueMap.getOrDefault(curCodes[2], 0));
                    }
                    cost += times[0];
                    curPrograms.remove(0);
                } else if (curCodeStr.contains("print")) {
                    String[] curCodes = curCodeStr.split(" ");
                    System.out.println(curIndex + 1 + ": " + valueMap.getOrDefault(curCodes[1], 0));
                    cost += times[3];
                    curPrograms.remove(0);
                } else if ("lock".equals(curCodeStr)) {
                    blockQueue.add(curIndex);
                    locked = true;
                    cost += times[4];
                    curPrograms.remove(0);
                } else if ("unlock".equals(curCodeStr)) {
                    locked = false;
                    if (blockQueue.size() != 0) {
                        curIndex = blockQueue.poll();
                    }
                    cost += times[5];
                    curPrograms.remove(0);
                } else if ("end".equals(curCodeStr)) {
                    finishNum++;
                    curPrograms.remove(0);
                    break;
                }
                if (!canVisitValue) {
                    break;
                }
            }
            curIndex = (curIndex + 1) % params[0];
        }
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
