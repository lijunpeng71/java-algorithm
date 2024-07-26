package cn.com.bjtu.algorithm.advanced;

import java.util.Scanner;
import java.util.Stack;

public class TransformString {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int batch = 1;
            while (true) {
                String firstStr = scanner.nextLine();
                String secondStr = scanner.nextLine();
                boolean flag = process(firstStr, secondStr);
                System.out.println("Case " + batch + ": " + (flag ? "Yes" : "No"));
                batch++;
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }

    private static boolean process(String firstStr, String secondStr) {
        if (firstStr.equals(secondStr)) {
            return true;
        }

        if (firstStr.length() != secondStr.length()) {
            return false;
        }
        int firstLen = firstStr.length();
        int secondLen = secondStr.length();
        Stack<Character> specialStack = new Stack<>();
        Stack<Integer> firstStack = new Stack<>();
        Stack<Integer> secondStack = new Stack<>();
        Stack<Stack<Character>> stackBStack = new Stack<>();
        Stack<Character> stackB = new Stack<>();
        int firstIndex = 0, secondIndex = 0;
        while (firstIndex < firstLen || specialStack.isEmpty()) {
            boolean flag = true;
            while (true) {
                stackB.push(firstStr.charAt(firstIndex++));
                if (stackB.peek().equals(secondStr.charAt(secondIndex))) {
                    //把相等的字符串加入到特殊栈里
                    specialStack.push(stackB.pop());
                    firstStack.push(firstIndex);
                    secondStack.push(secondIndex);
                    stackBStack.push(stackB);
                    secondIndex++;
                }
            }
        }
        return false;
    }
}
