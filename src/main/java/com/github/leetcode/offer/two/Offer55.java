package com.github.leetcode.offer.two;

public class Offer55 {

    public boolean isBalanced(TreeNode root) {
        return dfs(root).balance;
    }

    Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(0,true);
        }
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        return new Pair(1 + Math.max(left.depth,right.depth),left.balance && right.balance && Math.abs(left.depth - right.depth) <= 1);
    }

    class Pair {
        int depth;
        boolean balance;

        public Pair(int depth, boolean balance) {
            this.depth = depth;
            this.balance = balance;
        }
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
