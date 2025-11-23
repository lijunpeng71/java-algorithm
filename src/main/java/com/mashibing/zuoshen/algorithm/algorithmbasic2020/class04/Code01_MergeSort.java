package com.mashibing.zuoshen.algorithm.algorithmbasic2020.class04;

import java.util.Arrays;

public class Code01_MergeSort {

    /**
     * 递归实现版
     *
     * @param arr
     */
    public static void mergeSort01(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int M = L + (R - L) / 2;
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //要么p1越界了，要么p2越界了
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    /**
     * 非递归方法实现
     *
     * @param arr
     */
    public static void mergeSort02(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        //设置步长
        int step = 1;
        while (step < N) {
            //当前左组的第一个位置
            int L = 0;
            while (L < N) {
                //先判断步长是否够
                if (step >= N - L) {
                    break;
                }
                int M = L + step - 1;
                int R = M + Math.min(step, N - M - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            //防止溢出
            if (step > N / 2) {
                break;
            }
            step <<= 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 5, 3, 6, 9, 1, 4, 2, 7, 0};
        mergeSort02(arr);
        System.out.println(Arrays.toString(arr));
    }
}
