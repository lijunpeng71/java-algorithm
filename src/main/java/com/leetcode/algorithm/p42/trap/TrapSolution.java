package com.leetcode.algorithm.p42.trap;

public class TrapSolution {
    public static int trap01(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public static int trap(int[] height) {
        int left = 1, right = height.length - 2;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int maxValue = 0;
        while (left <= right) {
            if (leftMax <= rightMax) {
                maxValue += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                maxValue += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        //int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {1, 2, 1, 2, 3, 1, 0, 1, 2, 0, 1, 0};
        int trap = trap(height);
        System.out.println(trap);
    }
}
