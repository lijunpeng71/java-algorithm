package com.mashibing.zuoshen.algorithm.algorithmbasic2020.class05;

public class Code01_CountOfRangeSum {

    public static int countRangeSum(long[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        //求前缀和
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return process(sum, 0, nums.length - 1, lower, upper);
    }

    /**
     * arr[L...R]已经不传进来了，只传进来sum(前缀和数组)
     * 在原始的arr[L...R]中，有多少个子数组累加和在[lower,upper]上
     *
     * @param sum
     * @param L
     * @param R
     * @param lower
     * @param upper
     * @return
     */
    public static int process(long[] sum, int L, int R, int lower, int upper) {
        if (L == R) {
            if (sum[L] >= lower && sum[L] <= upper) {
                return 1;
            } else {
                return 0;
            }
        }
        int mid = L + (R - L) / 2;
        int leftPart = process(sum, L, mid, lower, upper);
        int rightPart = process(sum, mid + 1, R, lower, upper);
        int merge = merge(sum, L, mid, R, lower, upper);
        return leftPart + rightPart + merge;
    }

    public static int merge(long[] arr, int L, int M, int R, int lower, int upper) {
        int ans = 0;
        int windowL = L;
        int windowR = L;
        for (int i = M + 1; i <= R; i++) {
            long min = arr[i] - upper;
            long max = arr[i] - lower;
            while (windowR <= M && arr[windowR] <= max) {
                windowR++;
            }
            while (windowL <= M && arr[windowL] < min) {
                windowL++;
            }
            ans += Math.max(0, windowR - windowL);
        }
        long[] help = new long[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 5, 3, 6, 9, 1, 4, 2, 7, 0};
    }
}
