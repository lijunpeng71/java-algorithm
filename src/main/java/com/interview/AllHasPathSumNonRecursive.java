package com.interview;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class AllHasPathSumNonRecursive {

    public static List<List<Integer>> hasPathSum(TreeNode root, int sum) {
        List<List<Integer>> pathList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            return pathList;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        Stack<Boolean> nodeVisitedStack = new Stack<>();
        TreeNode head = root;
        Boolean flag = false;
        do {
            while (head != null) {
                nodeStack.push(head);
                path.add(head.val);
                if (valueStack.isEmpty()) {
                    valueStack.push(head.val);
                } else {
                    valueStack.push(valueStack.peek() + head.val);
                }
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
                Integer headValue = valueStack.pop();
                if (head.left == null && head.right == null && headValue == sum) {
                    pathList.add(new ArrayList<>(path));
                }
                path.remove(path.size() - 1);
                head = null;
            }
        } while (!(head == null && nodeStack.isEmpty()));

        return pathList;
    }

    public static void printPath(List<Integer> path) {
        for (int num : path) {
            System.out.print(num + " ");
        }
        System.out.println();
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
        List<List<Integer>> pathList = hasPathSum(root, sum);
        pathList.forEach(AllHasPathSumNonRecursive::printPath);
    }
}