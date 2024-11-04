package cn.com.bjtu.citel.algorithm.base;

import cn.hutool.core.util.ArrayUtil;

import java.util.*;

public class QueueUp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int patch = 1;
            while (true) {
                int lines = Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray()[0];
                if (lines == 0) {
                    continue;
                }
                Map<String, Integer> elementGroupMap = new HashMap<>();
                for (int i = 0; i < lines; i++) {
                    String elementStr = scanner.nextLine();
                    String[] elements = elementStr.split(" ");
                    for (int j = 0; j < Integer.parseInt(elements[0]); j++) {
                        elementGroupMap.put(elements[j + 1], i);
                    }
                }
                List<String> queueList = new ArrayList<>();
                System.out.println("Case #" + patch + ":");
                boolean process = true;
                while (process) {
                    String commandAndArgumentStr = scanner.nextLine();
                    String[] commandAndArgument = commandAndArgumentStr.split(" ");
                    String command = commandAndArgument[0];
                    String argument = null;
                    if (commandAndArgument.length > 1) {
                        argument = commandAndArgument[1];
                    }
                    Integer index = null;
                    List<String> sameGroupElemFromList = null;
                    switch (command) {
                        case "enqueue":
                            doEnqueue(argument, elementGroupMap, queueList);
                            break;
                        case "dequeue":
                            String dequeueArgument = doDequeue(queueList);
                            if (dequeueArgument != null && !dequeueArgument.isBlank()) {
                                System.out.println(dequeueArgument);
                            }
                            break;
                        case "deqteam":
                            sameGroupElemFromList = doDeqteam(argument, queueList, elementGroupMap);
                            if (sameGroupElemFromList != null && !sameGroupElemFromList.isEmpty()) {
                                for (int i = 0; i < sameGroupElemFromList.size(); i++) {
                                    if (i == 0) {
                                        System.out.print(sameGroupElemFromList.get(i));
                                    } else {
                                        System.out.print(" " + sameGroupElemFromList.get(i));
                                    }
                                }
                                System.out.println();
                            }
                            break;
                        case "stop":
                            patch++;
                            process = false;
                            break;
                    }
                }
            }
        } catch (Exception e) {
            System.exit(0);
        }

    }

    private static void doEnqueue(String argument, Map<String, Integer> elementGroupMap, List<String> queueList) {
        Integer group = elementGroupMap.get(argument);
        if (group == null) {
            queueList.add(argument);
            return;
        }
        Integer lastIndex = findLastSameElemFromList(group, elementGroupMap, queueList);
        if (lastIndex != null) {
            queueList.add(lastIndex + 1, argument);
        } else {
            queueList.add(argument);
        }
    }

    private static String doDequeue(List<String> queueList) {
        if (queueList.isEmpty()) {
            return null;
        }
        String head = queueList.get(0);
        queueList.remove(0);
        return head;
    }

    private static List<String> doDeqteam(String argument, List<String> queueList, Map<String, Integer> elementGroupMap) {
        //是否在队列里面
        if (!queueList.contains(argument)) {
            return null;
        }
        List<String> sameGroupElemFromList = new ArrayList<>();
        //是否有分组信息
        Integer group = elementGroupMap.get(argument);
        if (group == null) {
            queueList.remove(argument);
            sameGroupElemFromList.add(argument);
            return sameGroupElemFromList;
        }
        queueList.forEach(tempArgument -> {
            if (group.equals(elementGroupMap.get(tempArgument))) {
                sameGroupElemFromList.add(tempArgument);
            }
        });
        queueList.removeAll(sameGroupElemFromList);
        return sameGroupElemFromList;
    }

    public static Integer findLastSameElemFromList(Integer group, Map<String, Integer> elementGroupMap, List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        Integer lastIndex = null;
        for (int i = 0; i < list.size(); i++) {
            Integer tempGroup = elementGroupMap.get(list.get(i));
            if (group.equals(tempGroup)) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }
}
