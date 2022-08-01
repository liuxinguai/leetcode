package com.github.leetcode.offer;

/**
 * 对称的二叉树
 * @author xinguai.liu
 */
public class Offer28 {

    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left,right.right) && check(left.right,right.left);
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
