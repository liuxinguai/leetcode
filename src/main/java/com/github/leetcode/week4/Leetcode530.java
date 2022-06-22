package com.github.leetcode.week4;

/**
 * 二叉搜索树的最小绝对差
 * @author xinguai.liu
 */
public class Leetcode530 {

    int pre = -1, ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans,root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
