package com.common;

import java.io.Serializable;

/**
 * @author junpeng.li
 * description : 二叉树通用公共类
 * date created in 2024-08-18 09:40
 */
public class TreeNode implements Serializable {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
