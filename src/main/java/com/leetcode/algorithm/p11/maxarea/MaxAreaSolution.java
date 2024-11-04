package com.leetcode.algorithm.p11.maxarea;

/**
 * @author [您的名字]
 * @date 2024-08-19 15:00
 * @description [类的简要描述]
 */
public class MaxAreaSolution {

    public static int maxArea(int[] height) {
        int beginIndex = 0, endIndex = height.length - 1;
        int maxArea = 0;
        while (beginIndex < endIndex) {
            if (height[beginIndex] > height[endIndex]) {
                maxArea = Math.max(maxArea, height[endIndex] * (endIndex - beginIndex));
                endIndex--;
            } else {
                maxArea = Math.max(maxArea, height[beginIndex] * (endIndex - beginIndex));
                beginIndex++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }
}
