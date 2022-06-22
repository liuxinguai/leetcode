package com.github.leetcode.week4;

/**
 * 左叶子之和
 * @author xinguai.liu
 */
public class Leetcode404 {

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root,0);
        return sum;
    }

    public void dfs(TreeNode root, int sign) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && sign == 1) {
            sum += root.val;
        }
        dfs(root.left,1);
        dfs(root.right,2);
    }

}
