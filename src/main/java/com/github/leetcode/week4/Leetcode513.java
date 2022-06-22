package com.github.leetcode.week4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找树左下角的值
 * @author xinguai.liu
 */
public class Leetcode513 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int leftNum = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            leftNum = queue.peek().val;
            for (int i = 0; i < n; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return leftNum;
    }

}
