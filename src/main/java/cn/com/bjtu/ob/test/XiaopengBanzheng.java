package cn.com.bjtu.ob.test;

import java.util.Scanner;

public class XiaopengBanzheng {

    static int n, m;
    static int MAX_M = 101, MAX_N = 501;
    static long[][] s = new long[MAX_M][MAX_N];
    static long[][] dp = new long[MAX_M][MAX_N];
    static Node[][] nodes = new Node[MAX_M][MAX_N];

    //定义节点
    static class Node {
        int x;
        int y;

        public Node() {
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 打印节点
     *
     * @param x
     * @param y
     */
    public static void printNode(int x, int y) {
        if (x == 0 || y == 0 || (nodes[x][y] == null)) return;
        printNode(nodes[x][y].x, nodes[x][y].y);
        System.out.println(y);
    }

    public static void main(String[] args) {
        //初始化动态数组
        for (int i = 0; i < MAX_M; i++) {
            for (int j = 0; j < MAX_N; j++) {
                dp[i][j] = Long.MAX_VALUE;
            }
        }
        //接收输入的行和列
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        //接收输入数据
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = scanner.nextInt();
            }
        }
        //初始化动态数组第一行
        for (int i = 1; i <= m; i++) {
            dp[1][i] = s[1][i];
        }
        //动态规划
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                long n1 = dp[i - 1][j];
                long n2 = dp[i][j - 1];
                long n3 = dp[i][j + 1];
                if (n1 <= n2 && n1 <= n3) {
                    dp[i][j] = n1 + s[i][j];
                    nodes[i][j] = new Node(i - 1, j);
                } else if (n2 <= n1 && n2 <= n3) {
                    dp[i][j] = n2 + s[i][j];
                    nodes[i][j] = new Node(i, j - 1);
                } else {
                    dp[i][j] = n3 + s[i][j];
                    nodes[i][j] = new Node(i, j + 1);
                }
            }
            for (int j = m; j >= 1; j--) {
                long n1 = dp[i - 1][j];
                long n2 = dp[i][j - 1];
                long n3 = dp[i][j + 1];
                if (n1 <= n2 && n1 <= n3) {
                    dp[i][j] = n1 + s[i][j];
                    nodes[i][j] = new Node(i - 1, j);
                } else if (n2 <= n1 && n2 <= n3) {
                    dp[i][j] = n2 + s[i][j];
                    nodes[i][j] = new Node(i, j - 1);
                } else {
                    dp[i][j] = n3 + s[i][j];
                    nodes[i][j] = new Node(i, j + 1);
                }
            }
        }
        long minAns = Long.MAX_VALUE;
        int index = 0;
        for (int i = 1; i <= m; i++) {
            if (dp[n][i] < minAns) {
                minAns = dp[n][i];
                index = i;
            }
        }
        printNode(n, index);
    }
}
