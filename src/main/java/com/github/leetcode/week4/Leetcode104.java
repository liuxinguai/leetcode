package com.github.leetcode.week4;

/**
 * 104. 二叉树的最大深度
 * @author xinguai.liu
 */
public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
