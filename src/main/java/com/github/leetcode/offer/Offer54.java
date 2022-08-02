package com.github.leetcode.offer;


public class Offer54 {

    int k, retVal;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return this.retVal;
    }

    void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.right);
        if (k == 0) return ;
        if (--k == 0) retVal = node.val;
        dfs(node.left);
    }



    class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
