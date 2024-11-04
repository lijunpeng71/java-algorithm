package com.interview;

import com.common.TreeNode;

import java.util.Stack;

/**
 * @author [您的名字]
 * @date 2024-08-18 15:40
 * @description [类的简要描述]
 */
public class BinaryTreeTraversal {

    public static void preOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            if (tempNode != null) {
                System.out.print(tempNode.val + "\t");
                //此处需要先放右后放左
                stack.push(tempNode.right);
                stack.push(tempNode.left);
            }
        }
    }

    public static void inOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        while (currNode != null || !stack.isEmpty()) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            System.out.print(currNode.val + "\t");
            currNode = currNode.right;
        }
    }

    public static void postOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> outputStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            if (tempNode != null) {
                outputStack.push(tempNode);
                stack.push(tempNode.left);
                stack.push(tempNode.right);
            }
        }
        while (!outputStack.isEmpty()) {
            System.out.print(outputStack.pop().val + "\t");
        }
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.print("前序遍历:");
        preOrderTraversal(root);
        System.out.print("\n中序遍历:");
        inOrderTraversal(root);
        System.out.print("\n后序遍历:");
        postOrderTraversal(root);
    }
}
