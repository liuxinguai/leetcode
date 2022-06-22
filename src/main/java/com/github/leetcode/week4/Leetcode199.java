package com.github.leetcode.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xinguai.liu
 */
public class Leetcode199 {

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    list.add(node.val);
                }
            }
        }
        return list;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,0, list);
        return list;
    }

    private void dfs(TreeNode root, int depth, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(root.val);
        }
        depth++;
        dfs(root.right,depth,result);
        dfs(root.left,depth,result);
    }


}
