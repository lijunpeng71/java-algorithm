package com.leetcode.algorithm.p851.loudandrich;

import java.util.ArrayList;
import java.util.List;

/**
 * @see https://leetcode.cn/problems/loud-and-rich/description/
 */
public class LoudAndRichSolution {

    /**
     * @param richer richer[i] = { a ,b } a比b更有钱 a -> b
     * @param quiet  quiet[i] = k, i 这个人安静值是k
     * @return 返回结果集
     */
    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        int N = quiet.length;
        List<List<Integer>> nexts = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            nexts.add(new ArrayList<>());
        }
        int[] degree = new int[N];
        for (int[] r : richer) {
            nexts.get(r[0]).add(r[1]);
            degree[r[1]]++;
        }

        //所有入度为0的点，入队列
        int[] zeroQueue = new int[N];
        int l = 0, r = 0;
        for (int i = 0; i < N; ++i) {
            if (degree[i] == 0) {
                zeroQueue[r++] = i;
            }
        }

        //ans[i]=j: 比j有钱的所有人里， j最安静
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i) {
            ans[i] = i;
        }
        while (l < r) {
            int cur = zeroQueue[l++];
            for (int next : nexts.get(cur)) {
                if (quiet[ans[next]] > quiet[ans[cur]]) {
                    ans[next] = ans[cur];
                }
                if (--degree[next] == 0) {
                    zeroQueue[r++] = next;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        int[] ans = loudAndRich(richer, quiet);
    }
}
