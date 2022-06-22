package com.github.leetcode.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xinguai.liu
 */
public class Leetcode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean right = true;
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (right) {
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                } else {
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                right = !right;
            }
            result.add(level);
        }
        return result;
    }

}
