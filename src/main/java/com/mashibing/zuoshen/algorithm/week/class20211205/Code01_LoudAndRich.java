package com.mashibing.zuoshen.algorithm.week.class20211205;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: junpeng.li
 * Date: 2024/11/4
 * Desc:
 * 有一组n 个人作为实验对象，从口到n-1编号，其中每个人都有不同数目的钱，
 * 以及不同程度的安静值 (quietness)
 * 为了方便起见，我们将编号为×的人简称为"person x"。
 * 给你一个数组 richer，其中 richer[i] = [ai, bi] 表示 person ai 比 person bi 更有钱
 * 另给你一个整数数组 quiet，其中 quiet[0]是 person i 的安静值
 * richer 中所给出的数据 逻辑自洽
 * 也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比t person x 更有钱的情况
 * 现在，返回一个整数数组 answer 作为答案，其中 answer]=y 的前提是：
 * 在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人（也就是安静值 quietly] 最小的人）
 */
public class Code01_LoudAndRich {

    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        int N = quiet.length;
        List<List<Integer>> nexts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nexts.add(new ArrayList<>());
        }
        //统计每个节点的入度
        int[] degree = new int[N];
        for (int[] r : richer) {
            nexts.get(r[0]).add(r[1]);
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
