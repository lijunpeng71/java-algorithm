package cn.com.bjtu.citel.algorithm.advanced;

import java.util.Scanner;
import java.util.Stack;

public class StringTransform {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int batch = 1;
            while (true) {
                String firstStr = scanner.nextLine();
                String secondStr = scanner.nextLine();
                if (firstStr.equals(secondStr)) {
                    System.out.println("Case " + batch + ": " + "Yes");
                    batch++;
                    continue;
                }
                boolean flag = process(firstStr, 0, secondStr, 0, new Stack<>());
                System.out.println("Case " + batch + ": " + (flag ? "Yes" : "No"));
                batch++;
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }

    private static boolean process(String firstStr, Integer firstIndex, String secondStr, Integer secondIndex, Stack<Character> stackB) {
        //基本情况
        if (secondIndex == secondStr.length()) {
            return firstIndex == firstStr.length() && stackB.isEmpty();
        }
        //方式1
        if (firstIndex < firstStr.length()) {
            Stack<Character> tempStack = (Stack<Character>) stackB.clone();
            tempStack.push(firstStr.charAt(firstIndex));
            if (process(firstStr, firstIndex + 1, secondStr, secondIndex, tempStack)) {
                return true;
            }
        }
        //方式2
        if (!stackB.isEmpty() && stackB.peek() == secondStr.charAt(secondIndex)) {
            Stack<Character> tempStack = (Stack<Character>) stackB.clone();
            tempStack.pop();
            if (process(firstStr, firstIndex, secondStr, secondIndex + 1, tempStack)) {
                return true;
            }
        }
        return false;
    }
}
