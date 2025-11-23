package cn.com.bjtu.ob.test;

import java.util.Scanner;

public class VisaProcessing {
    static final int MAX_N = 550;
    static final int MAX_M = 110;
    static int[][] s = new int[MAX_M][MAX_N];
    static long[][] dp = new long[MAX_M][MAX_N];
    static int[][][] nodes = new int[MAX_M][MAX_N][2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < MAX_M; i++) {
            for (int j = 0; j < MAX_N; j++) {
                dp[i][j] = Long.MAX_VALUE;
            }
        }

        for (int i = 1; i <= m; i++) {
            dp[1][i] = s[1][i];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                long n1 = dp[i - 1][j];
                long n2 = dp[i][j - 1];
                long n3 = dp[i][j + 1];
                if (n1 <= n2 && n1 <= n3) {
                    dp[i][j] = n1 + s[i][j];
                    nodes[i][j][0] = i - 1;
                    nodes[i][j][1] = j;
                } else if (n2 <= n1 && n2 <= n3) {
                    dp[i][j] = n2 + s[i][j];
                    nodes[i][j][0] = i;
                    nodes[i][j][1] = j - 1;
                } else {
                    dp[i][j] = n3 + s[i][j];
                    nodes[i][j][0] = i;
                    nodes[i][j][1] = j + 1;
                }
            }
            for (int j = m; j >= 1; j--) {
                long n1 = dp[i - 1][j];
                long n2 = dp[i][j - 1];
                long n3 = dp[i][j + 1];
                if (n1 <= n2 && n1 <= n3) {
                    dp[i][j] = n1 + s[i][j];
                    nodes[i][j][0] = i - 1;
                    nodes[i][j][1] = j;
                } else if (n2 <= n1 && n2 <= n3) {
                    dp[i][j] = n2 + s[i][j];
                    nodes[i][j][0] = i;
                    nodes[i][j][1] = j - 1;
                } else {
                    dp[i][j] = n3 + s[i][j];
                    nodes[i][j][0] = i;
                    nodes[i][j][1] = j + 1;
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

    static void printNode(int x, int y) {
        if (x == 0 || y == 0 || (nodes[x][y] == null)) return;
        printNode(nodes[x][y][0], nodes[x][y][1]);
        System.out.println(y);
    }
}