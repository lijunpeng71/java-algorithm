package com.leetcode.algorithm.p274.hindex;

public class HIndexSolution {

    public static int hIndex01(int[] citations) {
        int left = 0, right = citations.length;
        int mid = 0, cnt = 0;
        while (left < right) {
            mid = (left + right + 1) >> 1;
            cnt = 0;
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= mid) {
                    cnt++;
                }
            }
            if (cnt >= mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int hIndex = hIndex01(citations);
        System.out.println(hIndex);
    }
}
