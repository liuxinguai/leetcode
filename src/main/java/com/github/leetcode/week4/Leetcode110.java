package com.github.leetcode.week4;


/**
 * 平衡二叉树
 * @author xinguai.liu
 */
public class Leetcode110 {

    class NodeItem {
        public int height;
        public boolean balanced;
        public NodeItem(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root).balanced;
    }

    private NodeItem dfs(TreeNode root) {
        if (root == null) {
            return new NodeItem(0,true);
        }
        NodeItem left = dfs(root.left);
        NodeItem right = dfs(root.right);
        return new NodeItem(1 + Math.max(left.height,right.height),(left.balanced && right.balanced) && Math.abs(left.height - right.height) <= 1 ? true : false);
    }

}
