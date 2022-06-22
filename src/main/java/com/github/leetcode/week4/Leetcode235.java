package com.github.leetcode.week4;

/**
 * 二叉搜索树的最近公共祖先
 * @author xinguai.liu
 */
public class Leetcode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val - root.val) * (q.val - root.val) <= 0) {
            return root;
        }
        return lowestCommonAncestor(root.val > p.val ? root.left : root.right,p,q);
    }
}
