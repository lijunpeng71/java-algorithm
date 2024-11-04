package com.leetcode.algorithm.p112.haspathsum;

import com.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author [您的名字]
 * @date 2024-08-18 17:56
 * @description [类的简要描述]
 */
public class HasPathSumSolution {

    public static boolean hasPathSumRecursive(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSumRecursive(root.left, targetSum - root.val) || hasPathSumRecursive(root.right, targetSum - root.val);
    }


    public static boolean hasPathSumNonRecursive(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<Integer> valueQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        valueQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            Integer currValue = valueQueue.poll();
            if (currNode.left == null && currNode.right == null) {
                if (currValue == targetSum) {
                    return true;
                }
                continue;
            }
            if (currNode.left != null) {
                nodeQueue.offer(currNode.left);
                valueQueue.offer(currValue + currNode.left.val);
            }
            if (currNode.right != null) {
                nodeQueue.offer(currNode.right);
                valueQueue.offer(currValue + currNode.right.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int sum = 22;
        System.out.println(hasPathSumNonRecursive(root, sum));
    }
}
