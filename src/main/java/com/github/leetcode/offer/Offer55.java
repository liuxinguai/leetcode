package com.github.leetcode.offer;

import java.util.LinkedList;
import java.util.Queue;

public class Offer55 {

    public int maxDepth(TreeNode root) {
//        return dfs(root);
        return scope(root);
    }

    int scope(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size --;
            }
            ans ++;
        }
        return ans;
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return 1 + Math.max(left,right);
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
