package com.github.leetcode.week4;

/**
 * 把二叉搜索树转换为累加树
 * @author xinguai.liu
 */
public class Leetcode538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
       return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}
