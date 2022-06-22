package com.github.leetcode.week4;


import java.util.Stack;

/**
 * @author xinguai.liu
 */
public class Leetcode114 {

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }

    TreeNode pre = null;

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten2(root.right);
        flatten2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    public void flatten3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (pre != null) {
                pre.right = node;
                pre.left = null;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            pre = node;
        }

    }

}
