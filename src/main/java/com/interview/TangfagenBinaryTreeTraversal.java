package com.interview;

import com.common.TreeNode;

import java.util.Stack;

/**
 * @author [您的名字]
 * @date 2024-08-18 15:40
 * @description [类的简要描述]
 */
public class TangfagenBinaryTreeTraversal {

    public static void preOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = root;
        if (root != null) {
            do {
                while (head != null) {
                    stack.push(head);
                    System.out.print(head.val + "\t");
                    head = head.left;
                }
                head = stack.pop();
                head = head.right;
            } while (!(head == null && stack.isEmpty()));
        }
    }

    public static void inOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = root;
        if (root != null) {
            do {
                while (head != null) {
                    stack.push(head);
                    head = head.left;
                }
                head = stack.pop();
                System.out.print(head.val + "\t");
                head = head.right;
            } while (!(head == null && stack.isEmpty()));
        }
    }

    public static void postOrderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Boolean> nodeVisitedStack = new Stack<>();
        TreeNode head = root;
        Boolean flag = false;
        if (root != null) {
            do {
                while (head != null) {
                    nodeStack.push(head);
                    nodeVisitedStack.push(flag);
                    head = head.left;
                }
                head = nodeStack.pop();
                flag = nodeVisitedStack.pop();
                if (!flag) {
                    nodeStack.push(head);
                    nodeVisitedStack.push(true);
                    head = head.right;
                } else {
                    System.out.print(head.val + "\t");
                    head = null;
                }
            } while (!(head == null && nodeStack.isEmpty()));
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
