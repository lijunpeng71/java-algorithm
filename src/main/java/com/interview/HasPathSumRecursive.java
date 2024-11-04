package com.interview;

import com.common.TreeNode;

/**
 * @Author junpeng.li
 * @Description
 * @Date created in 2024-08-18 09:38
 */
public class HasPathSumRecursive {


    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 一个二叉树和给定的 sum 值（22）的路径和问题。
     * 题目描述了给定一个二叉树，需要判断从根节点到叶节点是否存在路径加和等于 sum 值，
     * 若存在则打印每条路径的节点值。给出的输入条件是 sum=22 以及二叉树的节点值，
     * 输出结果为两条路径 [5,4,11,2] 和 [5,8,4,5]
     *
     * @param args
     */
    public static void main(String[] args) {
        //构建二叉树
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
        boolean hasPathSum = hasPathSum(root, sum);
        System.out.println(hasPathSum);
    }
}
