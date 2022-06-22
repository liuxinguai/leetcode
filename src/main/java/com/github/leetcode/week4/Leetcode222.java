package com.github.leetcode.week4;

/**
 * 222. 完全二叉树的节点个数
 * @author xinguai.liu
 */
public class Leetcode222 {


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }


}
