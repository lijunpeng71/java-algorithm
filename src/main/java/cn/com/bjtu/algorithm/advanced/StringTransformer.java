package cn.com.bjtu.algorithm.advanced;

import java.util.Stack;

public class StringTransformer {

    public static boolean isEquivalent(String A, String B) {
        // 如果长度不同，直接返回false
        if (A.length() != B.length()) {
            return false;
        }

        // 使用栈来模拟C的入栈和出栈操作
        Stack<Character> stackC = new Stack<>();
        int indexB = 0; // B字符串的索引

        for (char a : A.toCharArray()) {
            stackC.push(a); // 将字符a放入C的尾部

            // 尝试匹配B中的字符
            while (!stackC.isEmpty() && indexB < B.length()) {
                if (stackC.peek() == B.charAt(indexB)) {
                    stackC.pop(); // 匹配成功，弹出C中的字符
                    indexB++; // B字符串索引向前移动
                } else {
                    break; // 如果不匹配，停止尝试匹配
                }
            }
        }

        // 如果B字符串的所有字符都被匹配，返回true
        return indexB == B.length();
    }

    public static void main(String[] args) {
        // 测试用例
        String[][] testCases = {
                {"abac", "acba"}
        };

        // 对每组输入数据进行判断并输出结果
        for (int i = 0; i < testCases.length; i++) {
            String A = testCases[i][0];
            String B = testCases[i][1];
            System.out.println("Case " + (i + 1) + ": " + (isEquivalent(A, B) ? "Yes" : "No"));
        }
    }
}